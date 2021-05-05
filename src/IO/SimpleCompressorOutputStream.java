package IO;

import java.io.IOException;
import java.io.OutputStream;

public class SimpleCompressorOutputStream extends OutputStream {
    private OutputStream out;

    public SimpleCompressorOutputStream(OutputStream toCompress) {
        super();
        out = toCompress;

    }

    @Override
    public void write(int b) throws IOException {

    }
    // SERVER
    public void write(byte[] byteMaze) throws IOException {
        int count_index = 0,i=0;
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
            out.write(Byte.toUnsignedInt((byte)byteMaze[i]));
            out.flush();
        }
        while(i<byteMaze.length-32)
        {
            while (byteMaze[i]==0)
            {
                i++;
                count_index++;
                if (i<byteMaze.length-32)
                    break;
            }
            out.write(Byte.toUnsignedInt((byte)count_index));
            out.flush();
            count_index=0;
            while (byteMaze[i]==1)
            {
                i++;
                count_index++;
                if (i<byteMaze.length-32)
                    break;
            }
            out.write(Byte.toUnsignedInt((byte)count_index));
            out.flush();
            count_index=0;
        }
    }
}
