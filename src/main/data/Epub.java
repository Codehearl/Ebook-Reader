package main.data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import  nl.siegmann.epublib.domain.Book;
import  nl.siegmann.epublib.domain.Resource;
import  nl.siegmann.epublib.epub.EpubReader;
public class Epub extends Document{
    /**
     * A creator function to create a document type from a file
     *
     * @param file the file to be worked on
     */
    public Epub(File file) {
        super(file);
    }

    @Override
    List<String> readContent(String filePath) {
        List<String> contents = new ArrayList<>();

        try {

            EpubReader epubReader = new EpubReader();

            Book book = epubReader.readEpub(new FileInputStream(filePath));

            for (Resource resource : book.getContents()) {
                String content = new String(resource.getData());
                contents.add(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contents;
    }
    }

