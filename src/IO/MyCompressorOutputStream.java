package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;


public class MyCompressorOutputStream extends OutputStream {

    private OutputStream out;

    public MyCompressorOutputStream() {
        OutputStream out;
    }

    public MyCompressorOutputStream(OutputStream toCompress) {
        super();
        out = toCompress;

    }
    public int to_decimal(String s)
    {
        String st=s;
        int sum=0;
        int two=1;
        int digit;
        for (int i=st.length()-1; i>-1;i--)
        {
            digit=(int)st.charAt(i)-48;
            sum=sum+two*digit;
            two=two*2;
        }
        return sum;
    }
    @Override
    public void write(int b) throws IOException {

    }
    /**
     * function write: get inputs: byte arrray- byteMaze that An array that represents
     * a non-shrinking maze and shrinks it into an array of bits that holds a mapped grouped
     * by a method of binary representation, each sequence of 8 bytes in the maze represented
     * a binary number and we will keep it as a number.
     * */
    public void write(byte[] byteMaze) throws IOException {
        int count_index = 0, i = 0;
        int rest = (byteMaze.length - 16 - 32) % 8;
        int division = (byteMaze.length - 16 - 32) / 8;
        /*a shfiut test*/
        if (byteMaze == null) {
            throw new NullPointerException("error");
        }
        if (byteMaze.length == 0) {
            return;
        }
        /*Copies the representation of the rows and columns of
        the maze as they are. Are located in cells 0-15 in the array*/
        for (i = 0; i < 16; i++) {
            out.write(Byte.toUnsignedInt((byte)byteMaze[i]));
            out.flush();

        }
        // i = 16 we finished with the row and column.
        // start compressing the maze.
        String st = "";    //he saved in st(string) 8 cells of maze in string that creat a binnary number/

        /*A loop that makes the contraction it passes over the values of the maze*/
        for (int d = 0; d < division; d++) {
            st = "";
            for (int j = 0; j < 8; j++) {

                st = st + byteMaze[i];
                i++;
            }

            int decimal = to_decimal(st);
            out.write(Byte.toUnsignedInt((byte) decimal));
            out.flush();
        }
        /*Copies the rest of the last limbs in the maze
        (if the length of the maze is not divided by 8)*/
        for (int j = 0; j < rest; j++) {
            out.write(Byte.toUnsignedInt((byte)byteMaze[i]));
            out.flush();
            i++;
        }

        /* Copies the starting point and goal point values. */
        while (i < byteMaze.length) {
            out.write(Byte.toUnsignedInt((byte)byteMaze[i]));
            out.flush();
            i++;
        }

    }
}
