package algorithms.mazeGenerators;

import java.util.ArrayList;

public class MyMazeGenerator extends AMazeGenerator {


    public Maze generate (int row, int col) {

        Maze maze = new Maze(row, col);
        // build maze and initialize with only walls
        StringBuilder s = new StringBuilder(col);
        for (int x = 0; x < col; x++)
            s.append('1');
        char[][] maz = maze.getMaze();
        for (int x = 0; x < row; x++)
            maz[x] = s.toString().toCharArray();
        // select random point and open as start node
        Point p = new Point((int) (Math.random() * row), (int) (Math.random() * col), null);
        int p_row = p.getP_row();
        int p_col = p.getP_col();
        maz[p_row][p_col] = 'S';

        // iterate through direct neighbors of node
        ArrayList<Point> frontier = new ArrayList<>();
        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0 || x != 0 && y != 0)
                    continue;
                try {
                    if (maz[p_row + x][p_col + y] == '.') continue;
                } catch (Exception e) { // ignore ArrayIndexOutOfBounds
                    continue;
                }
                // add eligible points to frontier
                frontier.add(new Point(p_row + x, p_col + y, p));
            }

        Point last = null;
        while (!frontier.isEmpty()) {

            // pick current node at random
            Point current = frontier.remove((int) (Math.random() * frontier.size()));
            Point op = current.opposite();
            int col_current = current.getP_col();
            int row_current = current.getP_row();
            try {
                // if both node and its opposite are walls
                if (maz[col_current][col_current] == '1') {
                    if (maz[op.getP_row()][op.getP_col()] == '1') {


                        // open path between the nodes
                        maz[row_current][col_current] = '0';
                        maz[op.getP_row()][op.getP_col()] = '0';

                        // store last node in order to mark it later
                        last = op;

                        // iterate through direct neighbors of node, same as earlier
                        for (int x = -1; x <= 1; x++)
                            for (int y = -1; y <= 1; y++) {
                                if (x == 0 && y == 0 || x != 0 && y != 0)
                                    continue;
                                try {
                                    if (maz[op.getP_row() + x][op.getP_col() + y] == '0') continue;
                                } catch (Exception e) {
                                    continue;
                                }
                                frontier.add(new Point(op.getP_row() + x, op.getP_col() + y, op));
                            }
                    }
                }
            } catch (Exception e) { // ignore NullPointer and ArrayIndexOutOfBounds
            }
            // if algorithm has resolved, mark end node
            if (frontier.isEmpty() && last!=null) {
                maz[last.getP_row()][last.getP_col()] = 'E';

            }
        }
        // print final maze
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
                System.out.print(maz[i][j]);
            System.out.println();

        }




                return maze;
    }

}

