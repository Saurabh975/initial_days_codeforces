import java.util.*;
public class cramTime {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextInt();
        long b=sc.nextInt();
        int x=0;
        while(multiply(x+1,x+2)<=a+b)x++;
        //System.out.println(x);
        ArrayList <Integer> ar=new ArrayList<>(),br=new ArrayList<>();
        for(int i=x;i>=1;i--)
        {
            if(a>=i){
                ar.add(i);a-=i;
            }
            else br.add(i);
        }
        System.out.println(ar.size());
        for(int c:ar)System.out.print(c+" ");
        System.out.println("\n"+br.size());
        for(int c:br)System.out.print(c+" ");
        System.out.println();
    }

    static long multiply(long a, long b)
    {
        long res = 0;
        while (a > 0) {
            if ((a & 1)==1) {
                res += b;
                //if (res >= M) res -= M;
            }
            a >>= 1;
            b <<= 1;
            //if (b >= M) b -= M;
        }
        //System.out.println(res);
        return res/2;
    }
}
