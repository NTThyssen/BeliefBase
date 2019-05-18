import java.util.ArrayList;

public class Main {

    private static BeliefBase BB = new BeliefBase();
    private static Expression exp = new Expression(true, new Variable(true,"b"), Connective.OR, new Variable(true, "c"));
    private static Expression exp1 = new Expression(true, new Variable(false,"b"), Connective.OR, new Variable(true, "d"));

    private static Variable var = new Variable(true,"c");
    private static Variable var1 = new Variable(true,"a");

    public static void main(String[] args) {


        //BB.addSentence(new Expression(true, new Variable(false, "a" ), Connective.AND, exp));
        BB.addSentence(var);
        BB.addSentence(var1);
        BB.addSentence(exp1);
        //InputParser ip = new InputParser();
        //BB.addSentence(ip.evaluateString("(a OR b)"));


        BB.printSentences();
        System.out.println(" ");
        BB.generateTruthTable();
        BB.printTruthTable();

        for (SentenceInterface si: BB.getVariables()) {
            System.out.println(si);
        }
        System.out.println(BB.getBeliefBase());

    }
}