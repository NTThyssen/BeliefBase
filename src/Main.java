import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.forEach(numbers ->
            System.out.println(numbers*20)
        );
        System.out.println("Hello Ai!");

    }
}
