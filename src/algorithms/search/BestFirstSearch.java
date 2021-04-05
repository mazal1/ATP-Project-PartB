package algorithms.search;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class BestFirstSearch extends ASearchingAlgorithm{
    private PriorityQueue<AState> openQueue;

    public BestFirstSearch() {
        super();
        this.openQueue = new PriorityQueue<AState>(new AStateComparator());
    }

    @Override
    public String getName() {
        return "BestFirstSearch";
    }

    @Override
    protected AState popOpenList() {
        super.popOpenList();
        return openQueue.poll();
    }

    @Override
    public Solution solve(ISearchable domain) {
        AState start = domain.getStartState();
        AState goal = domain.getGoalState();
        openQueue.add(start);
        closeList.put(start, start.getCameFrom());
        while (!openQueue.isEmpty())
        {
            AState current = popOpenList();
            if (current.equals(goal))
                break;
            ArrayList<AState> successors = domain.getAllSuccessors(current);
            for (AState neighbour : successors) {
                if (goal.equals(neighbour))
                    return new Solution(solution(start,neighbour));
                if (!closeList.containsKey(neighbour) && !openQueue.contains(neighbour)){
                    closeList.put(neighbour,neighbour.getCameFrom());
                    openQueue.add(neighbour);
                }
            }
        }
        return new Solution(solution(start,goal));
    }

}
