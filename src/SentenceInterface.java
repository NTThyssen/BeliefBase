public interface SentenceInterface {

    @Override
    public String toString();

    Connective getConnective();
    SentenceInterface getSentence1();
    SentenceInterface getSentence2();

}
