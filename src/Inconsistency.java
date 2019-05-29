import java.util.ArrayList;

public class Inconsistency {

    private int row;
    private ArrayList<Integer> zeroList;

    public Inconsistency(int row) {
        this.row = row;
        this.zeroList = new ArrayList<>();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public ArrayList<Integer> getZeroList() {
        return zeroList;
    }

    public void setZeroList(ArrayList<Integer> zeroList) {
        this.zeroList = zeroList;
    }
}
