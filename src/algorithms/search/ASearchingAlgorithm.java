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
    public Solution solve(ISearchable problem){
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return visitedNodes;
    }

    public abstract String getName();
}
