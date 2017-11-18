import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
    private static HashMap<Integer, BigInteger> fact = new HashMap<>();   
    private static BigInteger getFact(int n) {
        if(fact.containsKey(n)) return fact.get(n);
        fact.put(n, (new BigInteger(Integer.toString(n))).multiply(getFact(n-1)));
        return fact.get(n);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        fact.put(0,BigInteger.ONE);
        int n = in.nextInt();
        System.out.println(getFact(n));
    }
}