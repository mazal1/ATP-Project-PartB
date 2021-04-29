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

    @Override
    public void write(int b) throws IOException {

    }
    public void write(byte[] byteMaze) throws IOException {
        int count_index = 0,i=0;
        int rest=(byteMaze.length-16-32)%8;
        int division=(byteMaze.length-16-32)/8;
        /*a shfiut test*/
        if (byteMaze==null)
        {
            throw new NullPointerException("error");
        }
        if (byteMaze.length==0)
        {
            return;
        }
        for (i=0; i<16;i++)
        {
            out.write(byteMaze[i]);
            out.flush();
        }
        String st="";

            for(int d=0; d<division; d++)
            {
                st="";
                for (int j=0; j<8; j++)
                {

                    st=st+byteMaze[i];
                    i++;
                }
                int decimal=Integer.parseInt(st,2);

                out.write(decimal);
                out.flush();
            }
        for (int j=0; j<rest; j++)
        {
            out.write(byteMaze[i]);
            out.flush();
            st=st+byteMaze[i];
            i++;
        }
        while(i<byteMaze.length)
        {
            out.write(byteMaze[i]);
            out.flush();
            i++;
        }

    }
}
