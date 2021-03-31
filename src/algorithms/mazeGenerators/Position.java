package algorithms.mazeGenerators;

public class Position {
    private int p_row;
    private int p_col;

    public Position(int row, int col) {
        this.p_row = row;
        this.p_col = col;
    }
   // public Position (Position other){
   //     this.p_row = other.p_row;
   //     this.p_col = other.p_col;
   // }


    @Override
    public String toString() {
        return "{" +p_row + ", " + p_col + '}';
    }

    public int getRowIndex() {
        return p_row;
    }
    public int getColumnIndex() {
        return p_col;
    }

}
