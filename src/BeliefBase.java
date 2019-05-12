import java.util.ArrayList;

public class BeliefBase {

    private ArrayList<SentenceInterface> beliefBase2 = new ArrayList<>();


    public void printSentences () {
        for (SentenceInterface si: beliefBase2) {
            System.out.println(si.toString());
        }
    }

    public void addSentence (SentenceInterface sentence) {

        beliefBase2.add(sentence);
    }









    /*
    private ArrayList<Sentence> beliefBase = new ArrayList<>();
    public void printSentence () {

        System.out.println("printing belief base: ");

        for (Sentence i: beliefBase) {

            System.out.println(i.getSentence());
        }
    }

    public void addSentence (Sentence sentence) {
        if (!sentenceDoesExist(sentence)) {

            beliefBase.add(sentence);
        }
    }

    public boolean sentenceDoesExist (Sentence sentence) {

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
    */
}