import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
    private static HashMap<Integer, BigInteger> fib = new HashMap<>();   
    private static BigInteger getFib(int n) {
        if(fib.containsKey(n)) return fib.get(n);
        fib.put(n, getFib(n-1).add(getFib(n-2)));
        return fib.get(n);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        fib.put(0,BigInteger.ZERO);
        fib.put(1,BigInteger.ONE);
        while(in.hasNext()) {
            int n = in.nextInt();
            System.out.println(getFib(n));
        }
    }
}