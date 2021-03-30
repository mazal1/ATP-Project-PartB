package algorithms.mazeGenerators;

public class main {
    public static void main(String[] args) {
        int row=10, col=10;
        MyMazeGenerator m = new MyMazeGenerator();
        System.out.println("shalom");
        if (m!=null)
        {
            m.generate(row,col);
        }


    }
}
