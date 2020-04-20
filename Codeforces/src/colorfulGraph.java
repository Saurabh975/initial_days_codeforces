
import java.io.*;
import java.util.*;
import static java.lang.Math.*;
public class colorfulGraph {

   static HashSet<Integer> adj[]=new HashSet[100005];
   static long ar[]=new long[100005];static long res[]=new long[100005];static long ans;

    static void Bolo_Jai_Mata_Di() {

        n = ni();
        m = ni();

        tsc();
        for(int i=0;i<100005;i++)adj[i]=new HashSet<>();
        for(int i=1;i<=n;i++)ar[i]=ni();
        ans=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            ans=min(ans,ar[i]);
        }

        while(m-->0)
        {
            long u=ar[ni()],v=ar[ni()];
            if(u==v)continue;
            get(u,v);get(v,u);
        }
        pl(ans);

        tec();                  //calculates the ending time of execution
        pwt();                //prints the time taken to execute the program

        flush();
    }

    static void get(long u, long v)
    {
        if(adj[(int)u].contains((int)v))return;
        adj[(int)u].add((int)v);
        res[(int)u]++;
        if(res[(int)u]>res[(int)ans]||(res[(int)u]==res[(int)ans] && u<ans))ans=u;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    static Calendar ts, te;                                                  //For time calculation
    static int mod9 = 1000000007;
    static int n, m, t, mod = 998244353;
    static Lelo input = new Lelo(System.in);
    static PrintWriter pw = new PrintWriter(System.out, true);


    public static void main(String[] args) {                                 //threading has been used to increase the stack size.

        new Thread(null, null, "BlackRise", 1 << 25)  //the last parameter is stack size which is desired,
        {
            public void run() {

                try {
                    Bolo_Jai_Mata_Di();
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

    static void pws(Object o) {
        pw.print(o + "");
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

    static void flush() {
        pw.flush();
        pw.close();
    }

    static void sort(int ar[]) {
        for (int i = 0; i < n; i++) {
            int ran = (int) (Math.random() * n);
            int temp = ar[i];
            ar[i] = ar[ran];
            ar[ran] = temp;
        }
        Arrays.sort(ar);
    }

    static void sort(long ar[]) {
        for (int i = 0; i < n; i++) {
            int ran = (int) (Math.random() * n);
            long temp = ar[i];
            ar[i] = ar[ran];
            ar[ran] = temp;
        }
        Arrays.sort(ar);
    }

    static void sort(char ar[]) {
        for (int i = 0; i < n; i++) {
            int ran = (int) (Math.random() * n);
            char temp = ar[i];
            ar[i] = ar[ran];
            ar[ran] = temp;
        }
        Arrays.sort(ar);
    }
}


