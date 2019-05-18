import java.util.ArrayList;

public class Main {

    private static BeliefBase BB = new BeliefBase();
    private static Expression exp = new Expression(true, new Variable(true,"b"), Connective.OR, new Variable(false, "c"));
    private static Variable var = new Variable(true,"c");

    public static void main(String[] args) {


        BB.addSentence(new Expression(false, new Variable(false, "a" ), Connective.AND, exp));
        BB.addSentence(var);

        BB.printSentences();


        InputParser ip = new InputParser();
        SentenceInterface test = ip.evaluateString("!(!(!A OR E) AND ((D IMPLICATION F) OR B))");
        //SentenceInterface test = ip.evaluateString("(A)");
        BB.addSentence(test);
        BB.printSentences();
        System.out.println("wow!");
    }
}
