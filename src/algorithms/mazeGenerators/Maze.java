package algorithms.mazeGenerators;
//import java.util.Random;

public class Maze {
    private int col;
    private int row;
    private Position StartPosition;
    private Position GoalPosition;
    private final int [][] maze;
    //Random randomGen = new Random();


    public Maze(int row, int col) {
        this.col = col;
        this.row = row;
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

    public int[][] getMaze() {
        return maze;
    }
    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setStartPosition(int p_row, int p_col) {
        StartPosition = new Position(p_row,p_col);
    }

    public void setGoalPosition(int p_row, int p_col) { GoalPosition = new Position(p_row, p_col);
    }
    public int get_Position_value(int row, int col)
    {
        return this.maze[row][col];

    }
    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void print(){
        StringBuilder path = new StringBuilder(" ");
        for (int row=0; row<this.maze.length; row++)
        {
            for(int col=0; col<this.maze[0].length ;col++)
            {
                if (this.getStartPosition().getRowIndex()==row && this.getStartPosition().getColumnIndex()==col)
                {
                  path.append("E ");
                }
                else if(this.getGoalPosition().getRowIndex()==row &&this.getGoalPosition().getColumnIndex()==col)
                {
                    path.append("S ");
                }
                else
                    path.append( this.get_Position_value(row, col)).append(" ");
            }
            System.out.println("{" + path + "}");
            path = new StringBuilder(" ");
        }
    }

    public void SetPosition(int row, int col, int value)
    {
        this.maze[row][col]=value;
    }


    public boolean cell_exist(int row, int col, int[][]maze)
    {
        if (row<0 || row>maze.length-1)
            return false;
        return col >= 0 && col <= maze[0].length - 1;
    }
    public int sum_neighbors(int row, int col, int[][]maze)
    {
        int sum_neighbors=4;
        if (row==0 || row==maze.length-1)
        {
            sum_neighbors--;

        }

        if (col==0 || col==maze[0].length-1)
            sum_neighbors--;
        return sum_neighbors;
    }
    public boolean must_neighbors_is_walls(int row, int col, int[][]maze)
    {
        int sum_neighbors=sum_neighbors(row, col, maze);
        int sum_wall_neighbors=0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0 || x != 0 && y != 0)
                    continue;
                if (cell_exist(row + x, col + y, maze) && get_Position_value(row + x, col + y) == 1)
                    sum_wall_neighbors++;
            }
        }
        return sum_neighbors == sum_wall_neighbors || sum_neighbors - 1 == sum_wall_neighbors;
    }




}
