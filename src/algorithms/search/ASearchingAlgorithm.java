package algorithms.search;

import java.util.*;

//
public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    protected Queue<AState> openList;
    protected HashMap<AState,AState> closeList;
    private int visitedNodes;
    public ASearchingAlgorithm(){
        openList = new LinkedList<AState>();
        closeList = new HashMap<AState,AState>();
        visitedNodes=0;
    }
    protected AState popOpenList(){
        visitedNodes++;
        return openList.poll();
    }
    protected ArrayList<AState> solution(AState start, AState goal){
        LinkedList<AState> path = new LinkedList<AState>();
        ArrayList<AState> solutionPath = new ArrayList<AState>();
        path.addFirst(goal);
        goal = closeList.get(goal);
        while(!start.equals(goal))
        {
            path.addFirst(goal);
            goal = goal.getCameFrom();
        }
        for (AState cell : path) {
            solutionPath.add(cell);
        }
        return solutionPath;
    }
    public Solution solve(ISearchable problem){return null;}

    @Override
    public int getNumberOfNodesEvaluated() {
        return visitedNodes;
    }

    public abstract String getName();
}
