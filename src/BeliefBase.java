import java.util.ArrayList;
import java.util.Arrays;

public class BeliefBase {

    private ArrayList<SentenceInterface> beliefBase = new ArrayList<>();
    private ArrayList<Variable> variables = new ArrayList<>();
    private ArrayList<ArrayList<Boolean>> variableValues = new ArrayList<ArrayList<Boolean>>();
    private ArrayList<ArrayList<Boolean>> sentenceValues = new ArrayList<ArrayList<Boolean>>();
    private ArrayList<String> truthTableHeader = new ArrayList<>();


    public void printSentences () {
        for (SentenceInterface si: beliefBase) {
            System.out.println(si.toString());
        }
    }

    public void addSentence (SentenceInterface sentence) {
        beliefBase.add(sentence);

    }


    public void printTruthTable() {

        for (int i = 0; i < Math.pow(2, variables.size()); i++) {
            sentenceValues.add(new ArrayList<>());
            for (int j = 0; j < beliefBase.size(); j++) {
                sentenceValues.get(i).add(false);
            }
        }
        for (SentenceInterface si: beliefBase) {
            truthTableHeader.add(si.toString());
        }
        //truthTableHeader.addAll(Arrays.asList("a V b", "b V c", "Theis", "Bijan0000"));

        int headerSize = 0;
        for(String s: truthTableHeader){
            if(s.length() > headerSize){
                headerSize = s.length();
            }
        }
        for (String s: truthTableHeader) {
            int space = headerSize - s.length();
            for (int i = 0; i < space - (space / 2); i++) {
                System.out.print(" ");
            }
            System.out.print(s);

            for (int i = 0; i <  (space / 2); i++) {
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println();


        for (int i = 0; i < sentenceValues.size(); i++) {
            for (int j = 0; j < sentenceValues.get(i).size(); j++) {

                for (int k = 0; k < (headerSize - 1) - (headerSize - 1) / 2 ; k++) {
                    System.out.print(" ");

                }
                if (sentenceValues.get(i).get(j)) {

                    System.out.print("1");
                }
                else {
                    System.out.print("0");
                }
                for (int h = 0; h <  (headerSize - 1) / 2 ; h++ ) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println();

        }


    }

    public void generateTruthTable () {

        for (SentenceInterface si: beliefBase) {
            generateVariables(si);
        }


    }

    public void generateVariables (SentenceInterface sentence) {

        if (sentence instanceof Variable) {
            boolean contains = false;
            for (Variable v: variables) {
                if (v.getName() == ((Variable) sentence).getName()) {
                    contains = true;
                    break;
                }
            }
            if (contains == false) {
                variables.add(new Variable(true, ((Variable) sentence).getName()));
            }
        }
        else if (sentence instanceof Expression) {
            generateVariables(((Expression) sentence).getSentence1());
            generateVariables(((Expression) sentence).getSentence2());
        }
    }


    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public ArrayList<SentenceInterface> getBeliefBase() {
        return beliefBase;
    }

    public void setBeliefBase(ArrayList<SentenceInterface> beliefBase) {
        this.beliefBase = beliefBase;
    }
}