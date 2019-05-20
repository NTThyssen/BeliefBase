import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static BeliefBase BB = new BeliefBase();
    private static Expression exp = new Expression(true, new Variable(true,"b"), Connective.OR, new Variable(false, "c"));
    private static Variable var = new Variable(true,"c");
    private static Variable var1 = new Variable(true,"d");

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BB.addSentence(new Expression(true, new Variable(false, "a" ), Connective.AND, exp));
        BB.addSentence(var);
        BB.addSentence(var1);
        InputParser ip = new InputParser();


        BB.addSentence(ip.evaluateString(input.nextLine()));
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