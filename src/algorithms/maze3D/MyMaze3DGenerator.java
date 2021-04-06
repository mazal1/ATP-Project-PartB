package algorithms.maze3D;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MyMaze3DGenerator extends AMaze3DGenerator{
    @Override
    public Maze3D generate(int depth, int row, int column) {
        Maze3D maze3D = new Maze3D(depth,row,column);
        Random randomCellIndex = new Random();
        // **************************************************
        // Initializing the visited boolean array and the wallList
        //****************************************************
        boolean[][][] visited = new boolean[depth][row][column];
        Stack<Position3D> wallsList = new Stack<Position3D>();
        ArrayList<Position3D> possibleGoalCells = new ArrayList<Position3D>();
        ArrayList<Position3D> neighbours = new ArrayList<Position3D>();
        //We pick a starter position
        Position3D start = new Position3D(0,0,column/2);
        maze3D.setStartPosition(start);

        //***************************************
        // We start with a grid full of walls
        //***************************************
        for (int m_depth =0; m_depth<maze3D.getMap().length;m_depth++)
        {
            for(int m_row = 0;m_row < maze3D.getMap()[0].length; m_row++)
            {
                for (int m_col = 0; m_col<maze3D.getMap()[0][0].length;m_col++){
                    visited[m_depth][m_row][m_col] = false;
                    maze3D.setCellValue(m_depth, m_row, m_col,1);
                }
            }
        }
        maze3D.setCellValue(start.getDepthIndex(), start.getRowIndex(), start.getColumnIndex(), 0);
//        maze3D.setCellValue(goal.getDepthIndex(), goal.getRowIndex(), goal.getColumnIndex(), 0);
        // mark first cell, the start cell, as visited.
        visited[start.getDepthIndex()][start.getRowIndex()][start.getColumnIndex()] = true;
//        visited[goal.getDepthIndex()][goal.getRowIndex()][goal.getColumnIndex()] = true;
        wallsList.push(start);
        // add the neighbours of the cell to the wallsList
//        addCellNeighbours(wallsList,start,maze3D,visited);
        while(!wallsList.isEmpty())
        {
            // get a random cell from the wallsList
            Position3D currentCell = wallsList.pop();
//            visited[currentCell.getDepthIndex()][currentCell.getRowIndex()][currentCell.getColumnIndex()]=true;
            addCellNeighbours(neighbours,currentCell,maze3D,visited);
            //neighbour.size is bigger then 0 if we have any unvisited cells.
            if(neighbours.size()>=2)
            {
                if(numOfWalls(neighbours,maze3D)>2)
                {
                    wallsList.push(currentCell);
                    Position3D neighbourCell = neighbours.get(randomCellIndex.nextInt(neighbours.size()));
                    maze3D.setCellValue(neighbourCell.getDepthIndex(), neighbourCell.getRowIndex(), neighbourCell.getColumnIndex(), 0);
                    visited[neighbourCell.getDepthIndex()][neighbourCell.getRowIndex()][neighbourCell.getColumnIndex()]=true;
                    wallsList.push(neighbourCell);
                    possibleGoalCells.add(neighbourCell);
                }

            }
            neighbours.clear();
        }
        maze3D.setGoalPosition(possibleGoalCells.get(randomCellIndex.nextInt(possibleGoalCells.size())));
        return maze3D;
    }
    private int numOfWalls(ArrayList<Position3D> neighbours, Maze3D maze){
        int wallNumber = 0;
        for (Position3D cell: neighbours) {
            if (maze.getMap()[cell.getDepthIndex()][cell.getRowIndex()][cell.getColumnIndex()] == 1)
                wallNumber++;
        }
        return wallNumber;
    }
    private void addCellNeighbours(ArrayList<Position3D> neighbours, Position3D position, Maze3D maze,boolean[][][]visited) {
        //the function adds neighbours to the list only if they haven't been visited yet
        int[][][] myMaze = maze.getMap();
        int p_depth = position.getDepthIndex();
        int p_row = position.getRowIndex();
        int p_column = position.getColumnIndex();

        for(int depth = -1 ; depth<= 1;depth++){
            for (int row = -1; row<=1; row++){
                for (int col= -1 ; col<=1; col++){
                    if( depth==0 && row==0 && col==0)// we will get our current "position"
                        continue;
                    else
                        {
                        if(maze.checkValidNeighbour(position,p_depth+depth,p_row+row,p_column+col))
                        {
                                Position3D neighbourCell = new Position3D(p_depth+depth, p_row+row,p_column+col);
                                if(visited[neighbourCell.getDepthIndex()][neighbourCell.getRowIndex()][neighbourCell.getColumnIndex()]==false)
                                    neighbours.add(neighbourCell);
                        }
                    }
                }
            }
        }

    }


}
