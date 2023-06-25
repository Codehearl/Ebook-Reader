package tests;

import main.data.Epub;
import main.data.Tokens;
import org.junit.jupiter.api.Assertions;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class DocumentTest {
    File file = new File("C:\\Users\\Oblivious\\Documents\\book.epub");
    Epub book = new Epub(file);
    List<String> fileContent = book.readContent();


    @org.junit.jupiter.api.Test
    void testEpubReadContent() {

        System.out.println(fileContent);
        Assertions.assertNotNull(fileContent);

    }
    @org.junit.jupiter.api.Test
    void testTokenize(){
        Tokens tokens = new Tokens();
        tokens = book.tokenize(fileContent);

        tokens.output();
        Assertions.assertNotNull(tokens);

    }
    @org.junit.jupiter.api.Test
    void testNormalizerPass(){
        String word = "ade()#---";
        String normal = "ade";
        Assertions.assertEquals(normal,book.normalize(word));
    }
    @org.junit.jupiter.api.Test
    void testNormalizerFail(){
        String word = null;
        Assertions.assertThrows(
                NullPointerException.class ,()->{
                    book.normalize(word);
                });
    }

    void testStemWordsEquals(){
        //TODO
    }
}

