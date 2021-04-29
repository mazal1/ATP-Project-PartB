package IO;

import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static void Test_CompressDecompressMaze() {
        double averageCompressionRate=0;
        int size = 5;
        String mazeFileName = "savedMaze.maze";
        AMazeGenerator mazeGenerator = new MyMazeGenerator();
        Maze maze = mazeGenerator.generate(size, size); //Generate new maze
        double mazeOriginalSize = maze.toByteArray().length;
        try {
            OutputStream out = new MyCompressorOutputStream(new FileOutputStream(mazeFileName));
            out.write(maze.toByteArray());
            out.flush();
            out.close();
        } catch (IOException e) {
//
           // appendToResultsFile(String.valueOf(total_test));
        }

        byte savedMazeBytes[] = new byte[0];
        try {
            InputStream in = new InputStream(new FileInputStream(mazeFileName));
            savedMazeBytes = new byte[maze.toByteArray().length];
            in.read(savedMazeBytes);
            in.close();
        } catch (IOException e) {

        }
        ///////////////DEBAG
        File compressed = new File("savedMaze.maze");
        //appendToResultsFile("compressed size - " + (double) compressed.length() / 1024);
        double current_comp = compressed.length();
        //appendToResultsFile("compression rate - " + (((double)compressed.length() / 1024) / mazeOriginalSize) * 100);
        Maze loadedMaze = new Maze(savedMazeBytes);
        boolean areMazesEquals = Arrays.equals(loadedMaze.toByteArray(), maze.toByteArray());
        int total_pass=0;
        if (areMazesEquals == true)
        {
            total_pass++;
        }
        else {
            appendToResultsFile(String.valueOf(total_test));
        }
    }
    public static void main(String[] args) {

    }
}

