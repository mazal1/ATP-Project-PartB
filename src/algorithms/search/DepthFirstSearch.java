package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm{
    private Stack<AState> openStack;
    public DepthFirstSearch() {

        super();
        openStack = new Stack<AState>();
    }

    @Override
    public String getName() {
        return "DepthFirstSearch";
    }



    @Override
    protected AState popOpenList() {
        super.popOpenList();
        return openStack.pop();
    }
    @Override
    public Solution solve(ISearchable problem) {
        AState start = problem.getStartState();
        AState goal = problem.getGoalState();
        openStack.push(start);
        closeList.put(start,start.getCameFrom());//visited
        AState current = popOpenList();
        while(!current.equals(goal))
        {
            ArrayList<AState> successors = problem.getAllSuccessors(current);
            for (AState neighbour : successors)
            {
                if(!closeList.containsKey(neighbour))
                {
                    closeList.put(neighbour,neighbour.getCameFrom());
                    openStack.push(neighbour);
                }
                if (neighbour.equals(goal))
                    return new Solution(solution(start,neighbour));
            }
            current = popOpenList();
        }
        return new Solution(solution(start,goal));
    }
}



