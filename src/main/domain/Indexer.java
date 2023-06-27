package main.domain;

import main.data.*;


import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Indexer {
    private final Tokens tokens= new Tokens();
    private final List<Document> documents = new ArrayList<>();
    private final List<InvertedIndex> InvertedIndexes = new ArrayList<>();
    private  String RootDirectory;



    //TODO complete indexer, by creating the different document types and adding them to the inverted indexes
    public    void Index(){

        File directory = new File(RootDirectory);
        if(directory.exists() && directory.isDirectory()){
            File[] files = directory.listFiles();

            try {
                assert files != null;
                traverseFiles(files);
            }
            catch (NullPointerException e){
                e.printStackTrace();
            }
            populateInvertedIndexes(tokens);


        }

    }
    public void  indexDocument(File file){
        Document document = getAppropriateDocument(file);
        if (!documents.contains(document)){
            populateInvertedIndexes(document.parse());
        }
    }

    private void populateInvertedIndexes(Tokens tokens){
        InvertedIndex invertedIndex;
        for (Token token: tokens.getTokens()
        ) {
            invertedIndex  = new InvertedIndex(token,documents);
            InvertedIndexes.add(invertedIndex);
        }
    }
    /**
     *get the extension of the file
     * @param file
     * @return
     */
    private  String getExtension(File file){

        Path path = file.toPath();

        String filename = path.getFileName().toString();
        String extension = "";
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex >= 0 && dotIndex < filename.length() - 1) {
            extension = filename.substring(dotIndex + 1);
        }
        return extension;

    }
    private void traverseFiles(File[] files){

        for (File file : files
        ) {
            Document document= getAppropriateDocument(file);
            documents.add(document);
            tokens.addTokens(document.parse());
        }
    }

    private  Document getAppropriateDocument(File file){
        Document document;
        switch (getExtension(file)) {
            case "epub":
                document = new Epub(file);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + getExtension(file));
        }
        return document;
    }


}
