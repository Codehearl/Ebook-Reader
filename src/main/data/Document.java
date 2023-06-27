package main.data;

import ca.rmen.porterstemmer.PorterStemmer;

import java.io.File;

import java.text.Normalizer;
import java.util.List;



/**
 * A class that stores the details of a particular document and performs necessary operations on it
 *
 */
public abstract class Document  {
    private Tokens tokens = new Tokens();
    private final String filepath;

    private final String filename;

    /**
     * A creator function to create a document type from a file
     * @param file the file to be worked on
     */
    public Document(File file) {
        this.filepath = file.getPath();
        this.filename = file.getName();

    }




    public Token getToken(String word){
        return tokens.getToken(word);

    }
    public boolean ContainsToken (String word){
        return tokens.findToken(word);

    }


    /**
     *Reads the content of the file
     * @return returns a list of text in the file
     */
    public abstract    List<String>  readContent();

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
        return tokens;
    }



    public  String normalize(String word){
        String normalizedWord = word.trim();
        normalizedWord = normalizedWord.toLowerCase();
        normalizedWord = Normalizer.normalize(normalizedWord, Normalizer.Form.NFD);
        normalizedWord = normalizedWord.replaceAll("\\p{M}","");
        normalizedWord = normalizedWord.replaceAll("[^a-z0-9 ]","");
        return normalizedWord;

    }
    public  String  stemWord(String word){
        PorterStemmer stemmer = new PorterStemmer();
        String s = stemmer.stemWord(word);
        return s;


    }
    public Tokens parse(){
        List<String> fileContent = readContent();
        tokens = tokenize(fileContent);
        return tokens;
    }

    public String getFilepath() {
        return filepath;
    }
    public String getFilename() {
        return filename;
    }
}
