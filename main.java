import java.util.*; import java.io.*;
/*
 * untitled.java
 *
 * Copyright 2019 Karan Kanojia <karankanojia@Karans-MacBook-Air.local>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */


public class Main{
    
    static Reader scan = new Reader(); Scanner scanner = new Scanner(System.in);
    static int MAX = 1111111, bit_max = 32, SQRT_BUCKET = 555;
    static HashMap<Long, Long> quickHash = new HashMap<>(); 
    static class pair<T,Q>{T first; Q second; pair(T first, Q second){this.first=first; this.second=second;}}
    static class graph<T,Q>{HashMap<T , HashMap<T, Q>> map = new HashMap<>();}
    
    
    public static void main(String[] args){
       
    }

    static long find(long num, Node root){
        long answer = 0; Node temp = root;
        for(int i=bit_max; i>=0; i--){
            long b = (num>>i)&1;
            if(b == 0){
                if(temp.left != null){temp = temp.left;}
                else{temp = temp.right; answer+= (1<<i);}
            }else{
                if(temp.right != null){temp = temp.right;}
                else{temp = temp.left; answer+= (1<<i);}
            }
        }
        return answer;
    }

    static void insert(long num, Node root){
        Node temp = root;
        for(int i=bit_max; i>=0; i--){
            long b = ((num>>i)&1);
            if(b == 0){ if(temp.left == null){temp.left = new Node();} temp = temp.left; }
            else{if(temp.right == null){temp.right = new Node();} temp = temp.right;}
        }
    }

    static class Node{ Node left, right; Node(){this.left=null; this.right=null;} }

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
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
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }


}
