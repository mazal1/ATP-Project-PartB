package algorithms.maze3D;

import algorithms.mazeGenerators.Maze;

public class Maze3D extends Maze {
    private int[][][] maze;
    private Position3D startPosition;
    private Position3D goalPosition;
    //------------------------------------------Maze3D Constructors---------------------------------------------------------
    public Maze3D(int row, int col, int depth) {

        this.maze = new int[row][col][depth];
        this.startPosition = null;
        this.goalPosition = null;
    }
    public Maze3D(Position3D start, Position3D goal, int[][][] map){
        this.maze = map;
        this.startPosition = start;
        this.goalPosition = goal;
    }
    //------------------------------------------Maze3D Constructors---------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
//--------------------------------------- getters & setters for the private fields of Maze3D----------------------------
    public int[][][] getMap() {
        return maze;
    }

    public void setMaze(int[][][] maze) {
        this.maze = maze;
    }

    public Position3D getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int depth, int row, int col){
        this.startPosition = new Position3D(depth,row,col);
    }
    public void setStartPosition(Position3D start){this.startPosition = start;}

    public Position3D getGoalPosition() {
        return goalPosition;
    }

    public void setGoalPosition(int depth, int row, int col) {
        this.goalPosition = new Position3D(depth,row,col);
    }
    public void setGoalPosition(Position3D goal){this.goalPosition = goal;}

    public void setCellValue(int depth, int row, int col, int value){this.maze[depth][row][col] = value;}
//------------------------------------------- getters & setters for the private fields of Maze3D------------------------

    public void print() {
        StringBuilder path = new StringBuilder(" ");
        String seperator = "";
        System.out.println("{");
        for (int depth = 0; depth < this.maze.length; depth++)
        {
            for (int row = 0; row < this.maze[0].length; row++)
            {
                for (int col = 0; col < this.maze[0][0].length; col++)
                {
                    if (this.getStartPosition().getRowIndex() == row && this.getStartPosition().getColumnIndex() == col && this.getStartPosition().getDepthIndex() == depth) {
                        path.append("S ");
                    }
                    else if (this.getGoalPosition().getRowIndex() == row && this.getGoalPosition().getColumnIndex() == col && this.getGoalPosition().getDepthIndex() == depth) {
                        path.append("E ");
                    }
                    else
                        path.append(this.get_Position_value(depth, row, col)).append(" ");

                }
                System.out.println("{" + path + "}");
                seperator = "{"+path+"}";
                path = new StringBuilder(" ");
            }
            // print --------- to seperate between the layers of each maze
            if(depth<this.maze.length-1)
            {
                for(int i=0; i<seperator.length();i++)
                    System.out.print("-");
                System.out.println("");
            }

            seperator = "";
        }
        System.out.println("}");
    }
    private int get_Position_value(int depth, int row, int col) {
        return this.maze[depth][row][col];
    }
    public boolean checkValidNeighbour(Position3D position, int depth, int row, int col) {
// this function returns true
//                      if the position given as an argument has a neighbor cell
//                      in the given row, depth and column
        int p_depth = position.getDepthIndex();
        int p_row = position.getRowIndex();
        int p_column = position.getColumnIndex();
        //check if depth is out of bound
        if((p_depth == 0 && depth == -1 ) || (p_depth == maze.length-1 && depth==maze.length))
            return false;
            //check if the row is out of bound
        else if((p_row == 0 && row == -1 ) || (p_row == maze[0].length-1 && row==maze[0].length))
            return false;
            //check if the column is out of bound
        else if((p_column == 0 && col == -1 ) || (p_column == maze[0][0].length-1 && col==maze[0][0].length))
            return false;
            //return true only if the row and column stay the same and the difference in the depth is 1
        else if(p_row == row && p_column == col && (p_depth+1 == depth || p_depth-1 ==depth))
            return true;
            //return true only if neighbour is in the same depth and column and the difference in row is 1
        else if (p_depth == depth && p_column == col && (p_row+1 == row || p_row-1 == row))
            return true;
            //return true if the neighbour's depth and row are the same and the difference in the column is 1
        else if (p_depth == depth && p_row == row && (p_column+1 == col || p_column-1 == col))
            return true;
        return false;

    }
    public Maze3D set_values_Maze3D(int depth, int row, int column, int value)
    {
        Maze3D maze3D = new Maze3D(depth,row,column);
        for (int m_depth =0 ;m_depth<depth;m_depth++)
        {
            for(int m_row = 0;m_row < row; m_row++)
            {
                for (int m_col = 0; m_col<column;m_col++)
                    maze3D.setCellValue(m_depth, m_row, m_col,1);
            }
        }
        return maze3D;
    }


}


