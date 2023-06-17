import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that stores the details of a particular document and performs necessary operations on it
 *
 */
abstract class Document {
    private List<Token> _token;
    private String filepath;

    private String filename;

    /**
     * A creator function to create a document type from a file
     * @param file the file to be worked on
     */
    public Document(File file) {
        this.filepath = file.getPath();
        this.filename = file.getName();

    }


    public Token getToken(String word){
        for (Token token: _token
        ) {
            if(word == token.getTerm()){
                return token;
            }

        }
        return null;

    }
    public boolean ContainsToken (String word){

        for (Token token: _token
             ) {
            if(word == token.getTerm()){
                return true;
            }

        }
        return false;

    }


    /**
     *Reads the content of the file
     * @param filepath The path of the document file
     * @return returns a list of text in the file
     */
    abstract   List<String>  readContent(String filepath);

    /**
     *
     * @param fileContent
     */
    public  List<Token> tokenize(List<String> fileContent){
        //TODO
        return _token;

    }


    public  void normalize(List<Token> fileContent){
        //TODO

    }
    public  void  stemWords(List<Token> tokens){
        //TODO

    }
    public void parse(){
        List<String> fiecontent = readContent(filepath);
        _token = tokenize(fiecontent);
        normalize(_token);
        stemWords(_token);



    }

    public String getFilepath() {
        return filepath;
    }
    public String getFilename() {
        return filename;
    }
}
