package test;
import algorithms.mazeGenerators.*;
import algorithms.search.*;
import java.util.ArrayList;

public class RunSearchOnMaze {
    public static void main(String[] args) {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(50, 50);
        maze.print();
        SearchableMaze searchableMaze = new SearchableMaze(maze);
//        solveProblem(searchableMaze, new BreadthFirstSearch());
        solveProblem(searchableMaze, new DepthFirstSearch());
//        solveProblem(searchableMaze, new BestFirstSearch());
    }

    private static void solveProblem(ISearchable domain, ISearchingAlgorithm
            searcher) {

//Solve a searching problem with a searcher
        long time_before=System.currentTimeMillis();
        Solution solution = searcher.solve(domain);
        long time_after = System.currentTimeMillis();
        System.out.println("time in ms for "+ searcher.getName() +" "+(time_after-time_before));
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s",
                searcher.getName(), searcher.getNumberOfNodesEvaluated()));
//Printing Solution Path
//        System.out.println("Solution path:");
//        ArrayList<AState> solutionPath = solution.getSolutionPath();
//        for (int i = 0; i < solutionPath.size(); i++) {
//            System.out.println(String.format("%s. %s", i, solutionPath.get(i)));
//        }
    }
}