import  java.io.*;
import java.util.*;
public class birthday {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long m=sc.nextLong();
        long k=sc.nextLong();
        long l=sc.nextLong();
        k+=l;

        long possiblity= (k+m-1)/m;
        if(possiblity*m>n)System.out.println(-1);
        else System.out.println(possiblity);
    }
}
