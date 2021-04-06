package algorithms.maze3D;

import algorithms.search.AState;
import algorithms.search.ISearchable;

import java.util.ArrayList;

public class SearchableMaze3D implements ISearchable {
    private Maze3D maze3D;

    public SearchableMaze3D(Maze3D maze){
        this.maze3D = maze;
    }
    @Override
    public AState getStartState() {
        return new Maze3DState(this.maze3D.getStartPosition());
    }

    @Override
    public AState getGoalState() {
        return new Maze3DState(this.maze3D.getGoalPosition());
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        Maze3DState currentCell = (Maze3DState) s;
        Position3D currentPosition = currentCell.getState();
        ArrayList<AState> successors = new ArrayList<AState>();
        int cellDepth = currentPosition.getDepthIndex();
        int cellRow = currentPosition.getRowIndex();
        int cellColumn = currentPosition.getColumnIndex();

        for (int depth =-1 ; depth<=1; depth ++){
            for (int row=-1; row<=1; row++){
                for (int col=-1; col<=1; col++){
                    if(depth == 0 && row ==0 && col ==0)
                        continue;
                    else if(maze3D.checkValidNeighbour(currentPosition, cellDepth+depth, cellRow+row,cellColumn+col)){
                        successors.add(new Maze3DState(cellDepth+depth, cellRow+row,cellColumn+col, currentCell, currentCell.getCost()+10));

                    }
                }
            }
        }
        return successors;
    }
}
