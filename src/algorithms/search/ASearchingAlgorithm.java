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
        ArrayList<AState> solutionPath = new ArrayList<AState>();
        solutionPath.add(0,goal);
        if (goal.getCameFrom()==null)
            goal = closeList.get(goal);
        while(!start.equals(goal))
        {
            if(!solutionPath.contains(goal))
                solutionPath.add(0,goal);
            goal = goal.getCameFrom();
        }
        solutionPath.add(0,start);
        return solutionPath;
    }
    public Solution solve(ISearchable problem){return null;}

    @Override
    public int getNumberOfNodesEvaluated() {
        return visitedNodes;
    }

    public abstract String getName();
}
