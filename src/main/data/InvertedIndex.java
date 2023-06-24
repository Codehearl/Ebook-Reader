package main.data;

import java.util.HashMap;
import java.util.List;

public class InvertedIndex {
    final Token token;
    private final HashMap<Document, Integer> documentHashMap;

    public  InvertedIndex(Token token, List<Document> documents){
        this.token = token;
        documentHashMap = new HashMap<>();
        documents.forEach(document -> {
            String term = token.getTerm();
            if(document.ContainsToken(term)) {
                int frequency = document.getToken(term).getFrequency();
                documentHashMap.put(document,frequency );
            }
        });



    }
}
