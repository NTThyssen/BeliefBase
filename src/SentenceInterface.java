public interface SentenceInterface {

    @Override
    public String toString();
    public boolean isTrue();

    Connective getConnective();
    SentenceInterface getSentence1();
    SentenceInterface getSentence2();

}
