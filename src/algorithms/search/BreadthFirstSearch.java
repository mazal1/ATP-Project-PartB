package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;

//
public class BreadthFirstSearch extends ASearchingAlgorithm{

    public BreadthFirstSearch() {
        super();
    }

    public Solution solve(ISearchable problem){
        AState start = problem.getStartState(); // startPosition
        AState goal = problem.getGoalState();//GoalPosition
        openList.add(start);
        AState current = popOpenList();
        while(!current.equals(goal))
        {
            ArrayList<AState> successors = problem.getAllSuccessors(current);
            for (AState route:successors) {
                if (route.equals(goal))
                {
                    return new Solution(solution(start,route));
                }
                if(!closeList.containsKey(route)){
                    closeList.put(route,current);
                    openList.add(route);
                }
            }
            current = popOpenList();
        }
        return new Solution(solution(start,goal));
    }
    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }
}
