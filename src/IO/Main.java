package IO;

import IO.MyCompressorOutputStream;
import IO.MyDecompressorInputStream;
import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.AState;
import algorithms.search.Solution;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    private static final String resultsFilePath = "results.txt";
    private static final String logFilePath = "results.log";
    private static int Port_ServerMazeGenerating = getRandomNumber(5000, 6000);
    private static int Port_ServerSearchProblemSolver = getRandomNumber(6001, 7000);
    private static int total_test = 0;
    private static int total_pass = 0;
    private static double avg_comp;
    private static final int ServerListeningIntervalMS = 1000;
    //<editor-fold desc="General">
    public static enum TestStatus {
        Passed, Failed;
    }

    private static String getTestStatusString(boolean testPassed) {
        return testPassed ? TestStatus.Passed.toString() : TestStatus.Failed.toString();
    }

    private static void appendToFile(String text, String filePath){
        try (java.io.FileWriter fw = new java.io.FileWriter(filePath, true)) {
            fw.write(text + "\r\n");
        } catch (IOException ex) {
            System.out.println(String.format("Error appending text to file: %s", filePath));
        }
    }

    private static void appendToResultsFile(String text){
        appendToFile(text, resultsFilePath);
    }

    private static void appendToLogFile(String text){
        appendToFile(text, logFilePath);
    }

    private static void appendToResultsAndLogFiles(String text) {
        appendToResultsFile(text);
        appendToLogFile(text);
    }

    private static void appendExceptionToFile(Exception e, String filePath) {
        String message = e.getMessage();
        if (message == null)
        {
            message =  String.valueOf(e);
        }
        appendToFile(String.format("Exception: %s", message),filePath);
        if (e.getStackTrace().length > 1)
        {
            String msg = String.valueOf(e.getStackTrace()[0]);
            appendToFile(String.format("Exception Stack Trace: %s", msg), filePath);
        }
        else
        {
            int x = 1;
        }
    }
    //</editor-fold>
    private static int getRandomNumber(int from, int to) {
        if (from < to)
            return from + new Random().nextInt(Math.abs(to - from));
        return from - new Random().nextInt(Math.abs(to - from));
    }

    private static Integer getFreePort() throws IOException {
        try (ServerSocket socket = new ServerSocket(0)) {
            return socket.getLocalPort();
        }
    }
    public static void main(String[] args) {
        try {

            Test_CompressDecompressMaze();

            Test_CommunicateWithServers();
        }
        catch (Exception e)
        {
            System.out.println("Thats a problema");
        }
    }

    private static void Test_CommunicateWithServers() {
    }

    //<editor-fold desc="Test_CompressDecompressMaze">
    private static void Test_CompressDecompressMaze() {
        double averageCompressionRate=0;
        int size = 8;
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
            appendToResultsFile(String.valueOf(total_test));
        }

        byte savedMazeBytes[] = new byte[0];
        try {
            InputStream in = new MyDecompressorInputStream(new FileInputStream(mazeFileName));
            savedMazeBytes = new byte[maze.toByteArray().length];
            in.read(savedMazeBytes);
            in.close();
        } catch (IOException e) {

        }
        File compressed = new File("savedMaze.maze");
        //appendToResultsFile("compressed size - " + (double) compressed.length() / 1024);
        double current_comp = compressed.length();
        //appendToResultsFile("compression rate - " + (((double)compressed.length() / 1024) / mazeOriginalSize) * 100);
        Maze loadedMaze = new Maze(savedMazeBytes);
        boolean areMazesEquals = Arrays.equals(loadedMaze.toByteArray(), maze.toByteArray());
        if (areMazesEquals == true)
        {
            total_pass++;
        }
        else {
            appendToResultsFile(String.valueOf(total_test));
        }
    }
    //</editor-fold>


    //</editor-fold>
}