package algorithms.maze3D;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

    public class MyMaze3DGenerator extends AMaze3DGenerator{
        Random random = new Random();


        @Override
        public Maze3D generate(int depth, int row, int column) {
            Maze3D maze3D= new Maze3D(depth,  row,  column);
            maze3D.set_values_Maze3D(depth,  row, column,1);
            // **************************************************
            // Initializing the visited boolean array and the wallList
            //****************************************************
            boolean[][][] visited = new boolean[depth][row][column];

            Stack<Position3D> wallsList = new Stack<Position3D>();
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
                    for (int m_col = 0; m_col<maze3D.getMap()[0][0].length;m_col++)
                        maze3D.setCellValue(m_depth, m_row, m_col,1);
                }
            }
            maze3D.setCellValue(start.getDepthIndex(), start.getRowIndex(), start.getColumnIndex(), 0);

            // mark first cell, the start cell, as visited.
            visited[start.getDepthIndex()][start.getRowIndex()][start.getColumnIndex()] = true;
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
                if(neighbours.size()>0)
                {
//                wallsList.push(currentCell);
                    Position3D neighbourCell = neighbours.get(randomCellIndex.nextInt(neighbours.size()));
                    maze3D.setCellValue(neighbourCell.getDepthIndex(), neighbourCell.getRowIndex(), neighbourCell.getColumnIndex(), 0);
                    visited[neighbourCell.getDepthIndex()][neighbourCell.getRowIndex()][neighbourCell.getColumnIndex()]=true;
//                for (Position3D cell:neighbours)
//                {
//                    wallsList.push(cell);
//                }
                    wallsList.push(neighbourCell);
                    neighbours.clear();
                }
                if(wallsList.isEmpty())
                    maze3D.setGoalPosition(currentCell);
            }
            maze3D.setCellValue(start.getDepthIndex(), start.getRowIndex(),start.getColumnIndex(),0);
            maze3D.setCellValue(maze3D.getGoalPosition().getDepthIndex(),maze3D.getGoalPosition().getRowIndex(),maze3D.getGoalPosition().getColumnIndex(),0);
            return maze3D;
        }
//    private boolean checkVisitedNeighbours(Position3D position, Maze3D maze, boolean[][][]visited){
//        int[][][] myMaze = maze.getMaze();
//        int p_depth = position.getDepthIndex();
//        int p_row = position.getRowIndex();
//        int p_column = position.getColumnIndex();
//        int numOfVisitedCells = 0;
//        for(int depth = -1 ; depth<= 1;depth++){
//            for (int row = -1; row<=1; row++){
//                for (int col= -1 ; col<=1; col++){
//                    if( depth==0 && row==0 && col==0)// we will get our current "position"
//                        continue;
//                    else
//                    {
//                        if(checkValidNeighbour(myMaze,position,p_depth+depth,p_row+row,p_column+col))
//                        {
//                            if(visited[p_depth+depth][p_row+row][p_column+col]==false)
//                                numOfVisitedCells++;
//                        }
//                    }
//                }
//            }
//        }
//        if(numOfVisitedCells>0)
//            return true;
//        return false;
//
//    }



        private void addCellNeighbours(ArrayList<Position3D> neighbours, Position3D position, Maze3D maze,boolean[][][]visited) {
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