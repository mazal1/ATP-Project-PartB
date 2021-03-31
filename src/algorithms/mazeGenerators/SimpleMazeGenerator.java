
package algorithms.mazeGenerators;
import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int row, int col) {

        Maze maze=new Maze( row, col);
        // create instance of Random class
        Random rand = new Random();
        int rand_int1;
        for (int i=0; i<row; i++) {
            for (int j = 0; j < col; j++) {
                rand_int1 = rand.nextInt(9);
                if (rand_int1 % 2 == 0)
                    maze.SetPosition(i,j,0);
                else
                    maze.SetPosition(i,j,1);
            }
        }
         return maze;


    }
}
