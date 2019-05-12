import java.util.ArrayList;

public class Main {

    private static BeliefBase BB = new BeliefBase();
    private static Expression exp = new Expression(true, new Variable(true,"b"), Connective.OR, new Variable(false, "c"));
    private static Variable var = new Variable(true,"c");

    public static void main(String[] args) {
        /*
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.forEach(numbers ->
            System.out.println(numbers*20)
        );
        System.out.println("Hello Ai!");
*/


        BB.addSentence(new Expression(false, new Variable(false, "a" ), Connective.BIIMPLICATION, exp));
        BB.printSentences();

    }
}
