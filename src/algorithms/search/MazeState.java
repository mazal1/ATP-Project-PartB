package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public class MazeState extends AState{
    private Position state;

    public Position getState() {
        return state;
    }

    public MazeState(Position position, int cost) {
        super(cost);
        this.state = position;
    }
    public MazeState(int row, int col, int cost) {
        super(cost);
        this.state = new Position(row,col);
    }

    @Override
    public String toString() {
        return this.state.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazeState mazestate = (MazeState) o;
        return this.state.equals(mazestate.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}

