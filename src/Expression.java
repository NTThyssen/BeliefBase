public class Expression implements SentenceInterface {

    private Connective connective;
    private SentenceInterface sentence1, sentence2;
    private boolean isTrue;

    public Expression(boolean isTrue, SentenceInterface sentence1, Connective connective, SentenceInterface sentence2) {
        this.isTrue = isTrue;
        this.sentence1 = sentence1;
        this.connective = connective;
        this.sentence2 = sentence2;
    }



    public String toString () {
        if (isTrue) {
            return "(" + sentence1.toString() + " " + connective.toString() + " " + sentence2.toString() + ")";
        }
        return "!(" + sentence1.toString() + " " + connective.toString() + " " + sentence2.toString() + ")";
    }


    public Connective getConnective() {
        return connective;
    }

    public SentenceInterface getSentence1() {
        return sentence1;
    }

    public void setSentence1(SentenceInterface sentence1) {
        this.sentence1 = sentence1;
    }

    public SentenceInterface getSentence2() {
        return sentence2;
    }

    public void setSentence2(SentenceInterface sentence2) {
        this.sentence2 = sentence2;
    }
}