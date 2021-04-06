package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMazeGenerator3D {
    @Override
    public long measureAlgorithmTimeMillis(int depth, int row, int col) {
        long time_before;
        long time_after;
        time_before = System.currentTimeMillis();
        generate(depth, row, col);
        time_after = System.currentTimeMillis();
        return time_after - time_before;
    }
}
