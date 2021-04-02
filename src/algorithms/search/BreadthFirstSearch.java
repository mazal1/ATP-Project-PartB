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
        start.setColor("Gray");
        start.setCost(0);
        openList.add(start);
        AState current = popOpenList();
        while(!current.equals(goal))
        {

//            AState current = popOpenList();
//            closeList.put(current,null);
            ArrayList<AState> successors = problem.getAllSuccessors(current);
            for (AState route:successors) {
                if(!closeList.containsKey(route)){
                    closeList.put(route,current);
                    openList.add(route);
                }
            }
            current = popOpenList();
//            for (AState neighbour: successors)
//            {
//                if(neighbour.getColor() == "White" && !closeList.containsKey(neighbour))
//                {
//                    neighbour.setColor("Gray");
//                    neighbour.setCost(current.getCost()+1);
//                    neighbour.setCameFrom(current);
//                    closeList.put(neighbour,current);
////                    closeList.add(neighbour);
//                    openList.add(neighbour);
//                }
//            }
//            current.setColor("Black");
        }
        LinkedList<AState> path = new LinkedList<AState>();
        ArrayList<AState> solutionPath = new ArrayList<AState>();
        while(!start.equals(goal))
        {
            path.addFirst(goal);
            goal = closeList.get(goal);
        }
        for (AState cell : path) {
            solutionPath.add(cell);
        }
        return new Solution(solutionPath);
    }
    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }
}
