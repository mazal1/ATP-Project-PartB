package algorithms.mazeGenerators;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
