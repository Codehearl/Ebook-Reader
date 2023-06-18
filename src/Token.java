
import java.util.Objects;

public class Token {
    final String term;
    private  int frequency;

    public Token(String term) {
        this.term = term;
        this.frequency = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return term.equals(token.getTerm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(term, frequency);
    }

    public void increaseFrequency() {
        this.frequency++;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getTerm() {
        return term;
    }
}
