import  java.io.*;
import java.util.*;
public class lcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int c = 0;
        long k=(int)Math.sqrt(n);
        for (int i = 1; i <= k; i++)
            if (n % i == 0) c+=2;

        if(k*k==n)c--;

        System.out.println(c);

    }
}
