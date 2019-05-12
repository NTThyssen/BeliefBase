import java.util.ArrayList;

public class Main {

    private static BeliefBase BB = new BeliefBase();

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.forEach(numbers ->
            System.out.println(numbers*20)
        );
        System.out.println("Hello Ai!");

        BB.printFormulas();

        BB.addSentence(new Sentence("hey"));

        BB.addSentence(new Sentence("hey"));

        BB.addSentence(new Sentence("hey ho"));

        BB.printFormulas();

    }
}
