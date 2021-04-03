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
        while(!openStack.isEmpty())
        {
            AState current = popOpenList();
            if(!closeList.containsKey(current))
                closeList.put(current,current.getCameFrom());
            ArrayList<AState> successors = problem.getAllSuccessors(current);
            for (AState neighbour : successors) {
                if(!closeList.containsKey(neighbour)){
                    openStack.push(neighbour);
                }
            }
        }
        return new Solution(solution(start,goal));
    }
//    public void DFS(ISearchable problem, AState current){
//        closeList.put(current,current.getCameFrom());
//        popOpenList();
//        ArrayList<AState> successors = problem.getAllSuccessors(current);
//        for (AState neighbour: successors) {
//            if(!closeList.containsKey(neighbour)){
//                DFS(problem,neighbour);
//            }
//
//        }
//
//    }
}



