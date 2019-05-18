import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static BeliefBase BB = new BeliefBase();
    private static Expression exp = new Expression(true, new Variable(true,"b"), Connective.OR, new Variable(false, "c"));
    private static Variable var = new Variable(true,"c");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BB.addSentence(new Expression(false, new Variable(false, "a" ), Connective.AND, exp));
        BB.addSentence(var);
        BB.printSentences();
    }
}
