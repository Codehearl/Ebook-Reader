package main.data;

import javax.print.Doc;
import java.util.HashMap;
import java.util.List;

public class InvertedIndex {
    final Token token;
    private final HashMap<Document, Integer> documentHashMap;

    public  InvertedIndex(Token token, List<Document> documents){
        this.token = token;
        documentHashMap = new HashMap<>();
        for (Document document : documents) {
            addDocument(document);
        }
    }


    public void addDocument(Document document) {
        String term = token.getTerm();
        if (document.ContainsToken(term)) {
            int frequency = document.getToken(term).getFrequency();
            documentHashMap.put(document, frequency);
        }
        //TODO add exceptions
    }
}


