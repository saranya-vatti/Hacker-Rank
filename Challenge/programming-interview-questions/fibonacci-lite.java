import java.io.*;
import java.util.*;

public class Solution {
    private static int[] fib;
    private static int getFib(int n) {
        if(n<=2) return fib[n];
        if(fib[n]!=0) return fib[n];
        fib[n] = getFib(n-1) + getFib(n-2);
        return fib[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==0) {
            System.out.println(0);
        } else if(n<=2) {
            System.out.println(1);
        } else {
            fib = new int[n+1];
            fib[0] = 0;
            fib[1] = 1;
            fib[2] = 1;
            System.out.println(getFib(n));
        }
    }
}