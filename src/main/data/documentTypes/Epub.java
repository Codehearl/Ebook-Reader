package main.data.documentTypes;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import main.data.Document;
import  nl.siegmann.epublib.domain.Book;
import  nl.siegmann.epublib.domain.Resource;
import  nl.siegmann.epublib.epub.EpubReader;
public class Epub extends Document {
    /**
     * A creator function to create a document type from a file
     *
     * @param file the file to be worked on
     */
    public Epub(File file) {
        super(file);
    }

    @Override
    public  List<String> readContent() {
        List<String> contents = new ArrayList<>();

        try {

            EpubReader epubReader = new EpubReader();

            Book book = epubReader.readEpub(new FileInputStream(getFilepath()));

            for (Resource resource : book.getContents()) {
                String content = new String(resource.getData());
                content = content.replaceAll("<[^>]+>"," ");
                String[] split = content.split(" ");

                for (String item: split
                     ) {

                    String normal = normalize(item);
                    normal = stemWord(normal);
                    if (!item.isEmpty() && !item.isBlank()) contents.add(normal);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contents;
    }


}

