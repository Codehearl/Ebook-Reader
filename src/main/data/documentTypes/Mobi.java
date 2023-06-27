package main.data.documentTypes;

import main.data.Document;

import java.io.File;
import java.util.List;

public class Mobi extends Document {
    /**
     * A creator function to create a document type from a file
     *
     * @param file the file to be worked on
     */
    public Mobi(File file) {
        super(file);
    }

    @Override
    public List<String> readContent() {
        return null;
    }
}
