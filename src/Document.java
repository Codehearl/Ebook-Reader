import java.io.File;

import java.util.List;

/**
 * A class that stores the details of a particular document and performs necessary operations on it
 *
 */
abstract class Document {
    private final Tokens tokens;
    private final String filepath;

    private final String filename;

    /**
     * A creator function to create a document type from a file
     * @param file the file to be worked on
     */
    public Document(File file) {
        this.filepath = file.getPath();
        this.filename = file.getName();
        tokens = new Tokens();

    }


    public Token getToken(String word){
        return tokens.getToken(word);

    }
    public boolean ContainsToken (String word){

        return tokens.findToken(word);

    }


    /**
     *Reads the content of the file
     * @param filepath The path of the document file
     * @return returns a list of text in the file
     */
    abstract   List<String>  readContent(String filepath);

    /**
     * tokenizes the content of the file
     * @param fileContent the content of the file to be tokenized
     * @return a list of tokens
     */
    public Tokens tokenize(List<String> fileContent){
        for (String word:fileContent
             ) {
            tokens.addToken(word);
        }
        //TODO
        return tokens;
    }



    public  void normalize(Tokens fileContent){
        //TODO

    }
    public  void  stemWords(Tokens tokens){
        //TODO

    }
    public void parse(){
        List<String> fileContent = readContent(filepath);
        tokenize(fileContent);
        normalize(tokens);
        stemWords(tokens);




    }

    public String getFilepath() {
        return filepath;
    }
    public String getFilename() {
        return filename;
    }
}
