public class Variable implements SentenceInterface {


    private String name;
    private boolean isTrue;

    public Variable(boolean isTrue, String name) {
        this.isTrue = isTrue;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public String toString () {
        if (isTrue) {
            return name;
        }
        return "!" + name;
    }

    @Override
    public Connective getConnective() {
        return null;
    }

    @Override
    public SentenceInterface getSentence1() {
        return null;
    }

    @Override
    public SentenceInterface getSentence2() {
        return null;
    }


}
