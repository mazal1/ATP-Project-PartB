package algorithms.mazeGenerators;
public abstract class AMazeGenerator implements IMazeGenerator{

    @Override
    public long measureAlgorithmTimeMillis(int row, int col) {
        long time_before;
        long time_after;
        long generate_time;
        time_before=System.currentTimeMillis();
        generate(row, col);
        time_after=System.currentTimeMillis();
        generate_time=time_after-time_before;
        return generate_time;

    }

}
