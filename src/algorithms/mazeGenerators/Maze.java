package algorithms.mazeGenerators;

public class Maze {
//    private int col;
//    private int row;
    private Position StartPosition;
    private Position GoalPosition;
    private int [][] maze;

    public Maze(int col, int row) {
//        this.col = col;
//        this.row = row;
        this.StartPosition = null;
        this.GoalPosition = null;
        this.maze = new int[row][col];
    }

    public Position getStartPosition() {
        return StartPosition;
    }

    public Position getGoalPosition() {
        return GoalPosition;
    }

    public void setStartPosition(int row, int column) {
        StartPosition = new Position(row,column);
    }

    public void setGoalPosition(int row, int column) {
        GoalPosition = new Position(row, column);
    }

    public int [][] getMap(){return this.maze;}
    public void print(){
        String path = " ";
        for (int row=0; row<this.maze.length; row++)
        {
            for(int col=0;col<this.maze[0].length;col++)
            {
                if (this.StartPosition.getRowIndex() == row && this.StartPosition.getColumnIndex()==col)
                    path+="S ";
                else if (this.GoalPosition.getRowIndex()==row && this.GoalPosition.getColumnIndex()==col)
                    path+="E ";
                else
                    path = path + this.maze[row][col] + " ";
            }
            System.out.println("{" + path + "}");
            path=" ";
        }
    }
//    public int getCol() {
//        return col;
//    }

//    public void setCol(int col) {
//        this.col = col;
//    }

//    public int getRow() {
//        return row;
//    }

//    public void setRow(int row) {
//        this.row = row;
//    }
    public void SetPosition(int row, int col, int value)
    {
        this.maze[row][col]=value;
    }

}
