import java.util.ArrayList;

public class Main {

    private static BeliefBase BB = new BeliefBase();
    private static Expression exp = new Expression(true, new Variable(true,"b"), Connective.OR, new Variable(false, "c"));
    private static Variable var = new Variable(true,"c");
    private static Variable var1 = new Variable(true,"d");

    public static void main(String[] args) {


        BB.addSentence(new Expression(true, new Variable(false, "a" ), Connective.AND, exp));
        BB.addSentence(var);
        BB.addSentence(var1);

        //BB.printSentences();
        System.out.println(" ");
        BB.generateTruthTable();
        BB.printTruthTable();

        for (SentenceInterface si: BB.getVariables()) {
            System.out.println(si);
        }
        System.out.println(BB.getBeliefBase());
    }
}