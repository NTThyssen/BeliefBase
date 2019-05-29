import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static BeliefBase BB = new BeliefBase();
    private static Expression exp = new Expression(true, new Variable(true,"a"), Connective.IMPLICATION, new Variable(true, "b"));
    private static Expression exp1 = new Expression(true, new Variable(true,"b"), Connective.IMPLICATION, new Variable(true, "a"));
    private static Expression exp2 = new Expression(false, new Variable(true,"a"), Connective.BIIMPLICATION, new Variable(true, "b"));

    private static Variable var = new Variable(true,"c");
    //private static Variable var1 = new Variable(true,"a");

    private static TextualInterface TI = new TextualInterface();

    private static InputParser ip = new InputParser();


    public static void main(String[] args) {
        ArrayList<SentenceInterface> list;
        TI.printMenu();
        int option;
        String sentence;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if (option == 1) {
                System.out.println();
                BB.printSentences();
                System.out.println();
                TI.printMenu();
            }

            else if(option == 2) {
                System.out.println("Type in your sentence:");
                Scanner scanner1 = new Scanner(System.in);
                sentence = scanner1.nextLine();
                list = ip.takeInput(sentence);
                for(SentenceInterface s : list) {
                    BB.addSentence(s);
                }
                TI.printMenu();
                BB.generateTruthTable();
            }

            else if (option == 3) {
                BB.printTruthTable();
                TI.printMenu();
            }

            else if (option == 4) {
                System.out.println("Type in sentence you want to remove from belief base:");
                Scanner scanner1 = new Scanner(System.in);
                sentence = scanner1.nextLine();
                BB.removeSentence(sentence);
                TI.printMenu();
            }

            else if(option == 5) {
                System.exit(0);
            }

            else {
                System.out.println("wrong input, please try again.");
            }
        }
    }
}