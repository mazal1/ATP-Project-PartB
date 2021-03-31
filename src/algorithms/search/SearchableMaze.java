package algorithms.search;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable{
    private Maze myMaze;

    public SearchableMaze(Maze myMaze) {
        this.myMaze = myMaze;
    }

    @Override
    public AState getStartState() {
        Position position = myMaze.getStartPosition();
        return new MazeState(position,0);

    }
    public boolean outOfBounds(int row, int col){
        if( row >= this.myMaze.getMap().length || row < 0 || col < 0 || col >= this.myMaze.getMap()[0].length)
            return true;
        return false;
    }
    public void VerticalAndHorizontalNeighbours(ArrayList<AState> successors, int row, int col){
        if (! outOfBounds(row,col)){
            if (this.myMaze.getMap()[row][col]==0)
                successors.add(new MazeState(row,col,10));
        }
    }
    public void upperRightDiagonalNeighbour(ArrayList<AState> successors, int row, int col){
        if (outOfBounds(row,col))//if indexes are out of bound
            return;
        else if (this.myMaze.getMap()[row][col]==0)
            if (outOfBounds(row,col-1))//check if the left neighbour of the diagonal cell is out of bound
                if (outOfBounds(row+1,col)) //check if the down neighbour is out of bound
                    return;
                else if (this.myMaze.getMap()[row+1][col]==0)
                    successors.add(new MazeState(row,col,15));
            else if(this.myMaze.getMap()[row][col-1]==0) // check if there's an available path
                successors.add(new MazeState(row,col,15));
    }
    public void lowerRightDiagonalNeighbour(ArrayList<AState> successors, int row, int col){
        if (outOfBounds(row,col))//if indexes are out of bound
            return;
        else if (this.myMaze.getMap()[row][col]==0)
            if (outOfBounds(row-1,col))//check if upper neighbour out of bound
                if (outOfBounds(row,col-1))
                    return;
                else if (this.myMaze.getMap()[row][col-1]==0)
                    successors.add(new MazeState(row,col,15));
            else if(this.myMaze.getMap()[row-1][col]==0) // check if there's an available path
                successors.add(new MazeState(row,col,15));
    }
    public void lowerLeftDiagonalNeighbour(ArrayList<AState> successors, int row, int col){
        if (outOfBounds(row,col))//if indexes are out of bound
            return;
        else if (this.myMaze.getMap()[row][col]==0)
            if (outOfBounds(row,col+1))//check if upper neighbour out of bound
                if (outOfBounds(row-1,col))
                    return;
                else if (this.myMaze.getMap()[row-1][col]==0)
                    successors.add(new MazeState(row,col,15));
            else if(this.myMaze.getMap()[row][col+1]==0) // check if there's an available path
                successors.add(new MazeState(row,col,15));
    }
    public void upperLeftDiagonalNeighbour(ArrayList<AState> successors, int row, int col){
        if (outOfBounds(row,col))//if indexes are out of bound
            return;
        else if (this.myMaze.getMap()[row][col]==0)
            if (outOfBounds(row,col+1))//check if upper neighbour out of bound
                if (outOfBounds(row+1,col))
                    return;
                else if (this.myMaze.getMap()[row+1][col]==0)
                    successors.add(new MazeState(row,col,15));
            else if(this.myMaze.getMap()[row][col+1]==0) // check if there's an available path
                successors.add(new MazeState(row,col,15));
    }

//    public void diagonalNeighbours(ArrayList<AState> successors, int row, int col,int a, int b, int c, int d)
//    {
//        if (outOfBounds(row,col))//if indexes are out of bound
//            return;
//        else if (this.myMaze.getMap()[row][col]==0)
//            if (outOfBounds(row+a,col+b))//check if upper neighbour out of bound
//                if (outOfBounds(row+c,col+d))
//                    return;
//                else if (this.myMaze.getMap()[row+c][col+d]==0)
//                    successors.add(new MazeState(row,col,15));
//            else if(this.myMaze.getMap()[row+a][col+b]==0) // check if there's an available path
//                successors.add(new MazeState(row,col,15));
//    }

    @Override
    public AState getGoalState() {
        Position position = this.myMaze.getGoalPosition();
        return new MazeState(position,0);
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        ArrayList<AState> successors = new ArrayList<>();
        MazeState mazestate = (MazeState) s;
        Position position = mazestate.getState();
        int row = position.getRowIndex();
        int col = position.getColumnIndex();
        VerticalAndHorizontalNeighbours(successors,row-1,col);
        upperRightDiagonalNeighbour(successors,row-1,col+1);
        VerticalAndHorizontalNeighbours(successors,row,col+1);
        lowerRightDiagonalNeighbour(successors,row+1,col+1);
        VerticalAndHorizontalNeighbours(successors,row+1,col);
        lowerLeftDiagonalNeighbour(successors,row+1,col-1);
        VerticalAndHorizontalNeighbours(successors,row,col-1);
        upperLeftDiagonalNeighbour(successors,row-1,col-1);
        return successors;
    }
}
