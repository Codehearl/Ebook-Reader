import java.util.HashMap;
import java.util.List;

public class InvertedIndex {
    private Token token;
    private HashMap<Document, int> documentHashMap;

    public  InvertedIndex(Token token, List<Document> documents){
        this.token = token;
        documents.forEach(document -> {
            String term = token.getTerm();
            if(document.ContainsToken(term)) {
                int frequency = document.getToken(term).getFrequency();
                documentHashMap.put(document,frequency );
            }
        });

    }
}
