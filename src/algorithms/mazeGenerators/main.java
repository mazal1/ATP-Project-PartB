package algorithms.mazeGenerators;

public class main{

//I wish is working!!
    public static void main(String[] args) {
        int row=10, col=20;
        MyMazeGenerator m = new MyMazeGenerator();
        SimpleMazeGenerator mm=new SimpleMazeGenerator();
        System.out.println("************************MyMazeGenerator***********************");
        m.generate(row, col).print();
        System.out.println("************************SimpleMazeGenerator***********************");
        mm.generate(row,col).print();




    }

}
