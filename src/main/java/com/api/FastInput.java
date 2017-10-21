package com.api;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FastInput {
    static class FastReader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream dataInputStream;
        private byte[] bytesBuffer;
        private int buffIterator, bytesEncountered;

        public FastReader()
        {
            dataInputStream = new DataInputStream(System.in);
            bytesBuffer = new byte[BUFFER_SIZE];
            buffIterator = bytesEncountered = 0;
        }

        public FastReader(String file_name) throws IOException
        {
            dataInputStream = new DataInputStream(new FileInputStream(file_name));
            bytesBuffer = new byte[BUFFER_SIZE];
            buffIterator = bytesEncountered = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int count = 0, currentChar;
            while ((currentChar = readData()) != -1)
            {
                if (currentChar == '\n')
                    break;
                buf[count++] = (byte) currentChar;
            }
            return new String(buf, 0, count);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = readData();
            while (c <= ' ')
                c = readData();
            boolean neg = (c == '-');
            if (neg)
                c = readData();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = readData()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = readData();
            while (c <= ' ')
                c = readData();
            boolean neg = (c == '-');
            if (neg)
                c = readData();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = readData()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = readData();
            while (c <= ' ')
                c = readData();
            boolean neg = (c == '-');
            if (neg)
                c = readData();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = readData()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = readData()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesEncountered = dataInputStream.read(bytesBuffer, buffIterator = 0, BUFFER_SIZE);
            if (bytesEncountered == -1)
                bytesBuffer[0] = -1;
        }

        private byte readData() throws IOException
        {
            if (buffIterator == bytesEncountered)
                fillBuffer();
            return bytesBuffer[buffIterator++];
        }

        public void close() throws IOException
        {
            if (dataInputStream == null)
                return;
            dataInputStream.close();
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader s=new FastReader();
        int n = s.nextInt();
        int k = s.nextInt();
        int count=0;
        while (n-- > 0)
        {
            int x = s.nextInt();
            if (x%k == 0)
                count++;
        }
        System.out.println(count);
    }
}
