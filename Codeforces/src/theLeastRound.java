// Author @ BlackRise :) //
// Birla Institute of Technology, Mesra//
import java.io.*;
import java.util.*;

public class theLeastRound {

    static void Blackrise() {                                                //The name Blackrise is my pen name... you can change the name according to your wish

        int n=ni();

        tsc();                                                               //calculates the starting time of execution

        long way5[][]=new long[1001][1001];
        long way2[][]=new long[1001][1001];

        char ch5[][]=new char[1001][1001];
        char ch2[][]=new char[1001][1001];

        boolean zero=false;int zero_x=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int x=ni();
                if(x==0){
                    zero=true;zero_x=j;
                }
                way2[i][j]=count_2(x);
                way5[i][j]=count_5(x);
            }
        }

        for(int i=1;i<=n;i++)
        {
            way2[0][i]+=way2[0][i-1];
            way5[0][i]+=way5[0][i-1];
            ch2[0][i]='R';
            ch5[0][i]='R';

            way2[i][0]+=way2[i-1][0];
            way5[i][0]+=way5[i-1][0];
            ch2[i][0]='D';
            ch5[i][0]='D';
        }

        for(int i = 1; i<n; i++) {
            for(int j = 1; j<n; j++) {
                if(way2[i-1][j] > way2[i][j-1]) {
                    way2[i][j] += way2[i][j-1];
                    ch2[i][j] = 'R';
                }
                else {
                    way2[i][j] += way2[i-1][j];
                    ch2[i][j] = 'D';
                }

                if(way5[i-1][j] > way5[i][j-1]) {
                    way5[i][j] += way5[i][j-1];
                    ch5[i][j] = 'R';
                }
                else {
                    way5[i][j] += way5[i-1][j];
                    ch5[i][j] = 'D';
                }
            }
        }
        if(way5[n-1][n-1]>1 && way2[n-1][n-1]>1 && zero)
        {
            pl(1);
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<zero_x;i++)sb.append('R');
            for(int i=0;i<n-1;i++)sb.append('D');
            for(int i=zero_x;i<n-1;i++)sb.append('R');

            pl(sb);
        }
        else
        {
            if(way5[n-1][n-1]<way2[n-1][n-1])
            {
                pl(way5[n-1][n-1]);
                StringBuilder sb=new StringBuilder();
                int x=n-1;
                int y=n-1;
                while(x!=0 || y!=0)
                {
                    sb.append(ch5[y][x]);
                    if(ch5[y][x]=='D')y--;
                    else x--;
                }
                pl(sb.reverse());
            }
            else
            {
                pl(way2[n-1][n-1]);
                StringBuilder sb=new StringBuilder();
                int x=n-1;
                int y=n-1;
                while(x!=0 || y!=0)
                {
                    sb.append(ch2[y][x]);
                    if(ch2[y][x]=='D')y--;
                    else x--;
                }
                pl(sb.reverse());
            }
        }



        tec();                  //calculates the ending time of execution
        pwt();                //prints the time taken to execute the program
    }

    static int count_2(int x)
    {
        if(x==0) return Integer.MAX_VALUE;
        int c=0;
        while(x%2==0)
        {
            c++;
            x/=2;
        }
        return c;
    }

    static int count_5(int x)
    {
        if(x==0) return Integer.MAX_VALUE;
        int c=0;
        while(x%5==0)
        {
            c++;
            x/=5;
        }
        return c;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    static Calendar ts, te;                                                  //For time calculation
    static int mod9 = (int) 1e9 + 7;
    static Lelo input = new Lelo(System.in);
    static PrintWriter pw = new PrintWriter(System.out, true);


    public static void main(String[] args) {                                 //threading has been used to increase the stack size.

        new Thread(null, null, "BlackRise", 100000000)  //the last parameter is stack size which is desired,
        {
            public void run() {

                try {
                    Blackrise();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    static class Lelo {                                              //Lelo class for fast input
        private InputStream ayega;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public Lelo(InputStream ayega) {
            this.ayega = ayega;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = ayega.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    // functions to take input//
    static int ni() {
        return input.nextInt();
    }

    static long nl() {
        return input.nextLong();
    }

    static double nd() {
        return input.nextDouble();
    }

    static String ns() {
        return input.readString();
    }

    //functions to give output
    static void pl() {
        pw.println();
    }

    static void p(Object o) {
        pw.print(o + " ");
    }

    static void pws(Object o){
        pw.print(o+"");
    }

    static void pl(Object o) {
        pw.println(o);
    }

    static void tsc()                                          //calculates the starting time of execution
    {
        ts = Calendar.getInstance();
        ts.setTime(new Date());
    }

    static void tec()                                          //calculates the ending time of execution
    {
        te = Calendar.getInstance();
        te.setTime(new Date());
    }

    static void pwt()                                          //prints the time taken for execution
    {
        pw.printf("\nExecution time was :- %f s\n", (te.getTimeInMillis() - ts.getTimeInMillis()) / 1000.00);
    }
}


