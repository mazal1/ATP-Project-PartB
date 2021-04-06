package algorithms.maze3D;

import algorithms.search.AState;
import algorithms.search.MazeState;

import java.util.Objects;

public class Maze3DState extends AState {
    private Position3D state;

    public Maze3DState(int cost) {
        super(cost);
        state=null;
    }
    public Maze3DState(int depth, int row, int column){
        super(10);
        this.state = new Position3D(depth,row,column);
    }
    public Maze3DState(int depth, int row, int column, AState papa, int cost){
        super(cost,papa);
        this.state = new Position3D(depth,row,column);
    }
    public Maze3DState(Position3D position){
        super(10);
        this.state = position;
    }
    public Position3D getState(){return state;}
    @Override
    public String toString() {
        return this.state.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maze3DState maze3dstate = (Maze3DState) o;
        return this.state.equals(maze3dstate.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
