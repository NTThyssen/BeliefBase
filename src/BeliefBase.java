import java.util.ArrayList;

public class BeliefBase {
    private ArrayList<Sentence> beliefBase = new ArrayList<>();


    public void printFormulas () {

        System.out.println("printing belief base: ");

        for (Sentence i: beliefBase) {

            System.out.println(i.getSentence());
        }
    }

    public void addSentence (Sentence sentence) {
        if (!formulaDoesExist(sentence)) {

            beliefBase.add(sentence);
        }
    }

    public boolean formulaDoesExist (Sentence sentence) {

        for (Sentence i: beliefBase) {
            if (i.getSentence().equals(sentence.getSentence())) {
                System.out.println("sentence ("+ sentence.getSentence() + ") does exist");
                System.out.println("adding (" + sentence.getSentence() + ") to the belief base");
                return true;
            }
        }
        System.out.println("sentence ("+ sentence.getSentence() + ") does not already exist");
        return false;
    }
    public ArrayList<Sentence> getBeliefBase() {
        return beliefBase;
    }

    public void setBeliefBase(ArrayList<Sentence> beliefBase) {
        this.beliefBase = beliefBase;
    }
}