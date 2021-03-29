package algorithms.search;

public interface ISearchable {
    MazeState search(ISearchable s);
    int getNumberOfVisitedNodes();
}
