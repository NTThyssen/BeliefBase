public class Main {

    private static BeliefBase BB = new BeliefBase();
    private static Expression exp = new Expression(true, new Variable(true,"b"), Connective.OR, new Variable(false, "c"));
    private static Variable var = new Variable(true,"c");

    public static void main(String[] args) {
        BB.addSentence(new Expression(false, new Variable(false, "a" ), Connective.OR, exp));
        BB.printSentences();

    }
}
