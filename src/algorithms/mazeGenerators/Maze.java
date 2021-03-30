package algorithms.mazeGenerators;
//import java.util.Random;

import java.util.Arrays;

public class Maze {
    private int col;
    private int row;
    private Position StartPosition;
    private Position GoalPosition;
    private char [][] maze;
    //Random randomGen = new Random();


    public Maze(int row, int col) {
        this.col = col;
        this.row = row;
        this.StartPosition = null;
        this.GoalPosition = null;
        this.maze = new char[row][col];
    }

    public Position getStartPosition() {
        return StartPosition;
    }

    public Position getGoalPosition() {
        return GoalPosition;
    }

    public char[][] getMaze() {
        return maze;
    }
    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setStartPosition(int p_row, int p_column) {
        StartPosition = new Position(p_row,p_column);
    }

    public void setGoalPosition(int p_row, int p_column) { GoalPosition = new Position(p_row, p_column);
    }


    public char [][] getMap(){return this.maze;}

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

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


    public void SetPosition(int row, int col, char value)
    {
        this.maze[row][col]=value;
    }

}
