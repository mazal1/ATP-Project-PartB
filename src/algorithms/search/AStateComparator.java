package algorithms.search;

import java.util.Comparator;

public class AStateComparator implements Comparator<AState> {
    //    A functor which compares between 2 AState objects by their cost.
    @Override
    public int compare(AState state1, AState state2) {
        return Integer.compare(state1.getCost(),state2.getCost());
    }
}
