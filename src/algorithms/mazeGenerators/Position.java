package algorithms.mazeGenerators;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public Position (Position other){
        this.row = other.row;
        this.column = other.column;
    }

    @Override
    public String toString() {
        return "{" +
                row +
                "," + column +
                '}';
    }

    public int getRowIndex() {
        return row;
    }
    public int getColumnIndex() {
        return column;
    }

}
