package algorithms.mazeGenerators;

public class Position {
    private int p_row;
    private int p_column;

    public Position(int row, int column) {
        this.p_row = row;
        this.p_column = column;
    }
    public Position (Position other){
        this.p_row = other.p_row;
        this.p_column = other.p_column;
    }


    //public Position(int i, int i1, Object o) {}


    @Override
    public String toString() {
        return "(" +
                p_row +
                "," + p_column +
                ')';
    }

    public int getRowIndex() {
        return p_row;
    }
    public int getColumnIndex() {
        return p_column;
    }

}
