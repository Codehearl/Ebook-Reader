import java.util.HashSet;

import java.util.Objects;

public class Tokens  {
    private final HashSet<Token> tokens;

    public Tokens() {
        tokens = new HashSet<>();
    }

    public Token getToken(String term) {
        for (Token token : tokens
        ) {
            if (Objects.equals(token.getTerm(), term)) {

                return token;

            }

        }
        return null;
    }

    public boolean findToken(String term) {
        for (Token token : tokens
        ) {
            if (Objects.equals(token.getTerm(), term)) {

                return true;

            }

        }
        return false;
    }
        public void addToken (String term){
         if (!findToken(term)){
             Token token = new Token(term);
             tokens.add(token);
         }
        else getToken(term).increaseFrequency();
        }

    }
