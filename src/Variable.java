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

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public String toString () {
        if (isTrue) {
            return name;
        }
        return "!" + name;
    }


}
