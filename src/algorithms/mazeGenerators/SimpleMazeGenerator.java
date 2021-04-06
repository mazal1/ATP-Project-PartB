
package algorithms.mazeGenerators;
import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int row, int col) {

        Maze maze=new Maze( row, col);
        maze.setStartPosition(0,0);
        maze.setGoalPosition(row-1,col-1);
        // create instance of Random class
        Random rand = new Random();
        for (int i=0; i<((row)*(col)/(row+col)); i++) {
            int randRow = rand.nextInt(row);
            int randCol = rand.nextInt(col);
            if( (randRow == maze.getStartPosition().getRowIndex() && randCol==maze.getStartPosition().getColumnIndex() )||
                    (randRow== maze.getGoalPosition().getRowIndex() && randCol==maze.getGoalPosition().getColumnIndex()) )
                continue;
            maze.SetPosition(randRow,randCol,1);
        }
         return maze;


    }
}
