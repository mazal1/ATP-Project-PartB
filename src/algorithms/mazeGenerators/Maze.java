package algorithms.mazeGenerators;

public class Maze {
    private int col;
    private int row;
    private int [][] maze;

    public Maze(int col, int row) {
        this.col = col;
        this.row = row;
        this.maze = new int[row][col];
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
    public void SetPosition(int row, int col, int value)
    {
        this.maze[row][col]=value;
    }

}
