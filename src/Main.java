import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static BeliefBase BB = new BeliefBase();
    private static Expression exp = new Expression(true, new Variable(true,"b"), Connective.OR, new Variable(true, "c"));
    private static Expression exp1 = new Expression(true, new Variable(false,"b"), Connective.OR, new Variable(true, "d"));

    private static Variable var = new Variable(true,"c");
    private static Variable var1 = new Variable(true,"a");

    private static TextualInterface TI = new TextualInterface();

    private static InputParser ip = new InputParser();


    public static void main(String[] args) {

        TI.printMenu();

        int option;
        String sentence;

        while(true) {

          //  BB.printSentences();
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();

            if (option == 1) {
                System.out.println();
                BB.printSentences();
                System.out.println();
                TI.printMenu();
            }

            else if(option == 2) {
                System.out.println("Type in your sentence");

                Scanner scanner1 = new Scanner(System.in);
                sentence = scanner1.nextLine();
                BB.addSentence(ip.evaluateString(sentence));
                System.out.println("Added: " + sentence + " to knowledge base\n");
                TI.printMenu();

            }

            else if (option == 3) {
                BB.generateTruthTable();
                BB.printTruthTable();
            }

            else if(option == 4) {
                System.exit(0);
            }

            else {
                System.out.println("wrong input, try again bro");
            }

        }






        /*

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

        */
    }
}