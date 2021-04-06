package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm{
//    private Stack<AState> openStack;
    public DepthFirstSearch() { super();}

    @Override
    public String getName() {
        return "DepthFirstSearch";
    }



    @Override
    public Solution solve(ISearchable problem) {
        AState start = problem.getStartState();
        AState goal = problem.getGoalState();
        openList.add(0,start);
        closeList.put(start,start.getCameFrom());//visited
//        AState current = popOpenList();
        while(!openList.isEmpty())
        {
            AState current = popOpenList();
            ArrayList<AState> successors = problem.getAllSuccessors(current);
            for (AState neighbour : successors)
            {
                if(!closeList.containsKey(neighbour))
                {
                    closeList.put(neighbour,neighbour.getCameFrom());
                    openList.add(0,neighbour);
                }
                if (neighbour.equals(goal))
                    return new Solution(solution(start,neighbour));
            }
//            current = popOpenList();
        }
        return new Solution(solution(start,goal));
    }
}



