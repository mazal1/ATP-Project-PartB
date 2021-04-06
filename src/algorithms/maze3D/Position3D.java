package algorithms.maze3D;

import java.util.Objects;

public class Position3D {
    private int depth;
    private int row;
    private  int column;

    public Position3D(int depth, int row, int col) {
        this.depth=depth;
        this.row=row;
        this.column=col;
    }

    public int getRowIndex() {
        return row;
    }

    public void setRowIndex(int p3_r) {
        this.row = p3_r;
    }

    public int getColumnIndex() {
        return column;
    }

    public void setColumnIndex(int p3_c) {
        this.column = p3_c;
    }

    public int getDepthIndex() {
        return depth;
    }

    public void setDepthIndex(int p3_d) {
        this.depth = p3_d;
    }

    @Override
    public String toString() {
        return "{" +depth +
                "," + row +
                "," + column +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position3D that = (Position3D) o;
        return row == that.row && column == that.column && depth == that.depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, depth);
    }
}
