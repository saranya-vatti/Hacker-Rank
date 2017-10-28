package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    private static BigInteger[] fact = new BigInteger[6];
    private static int computedFacttill = 0;

    private static BigInteger computeFact(int n) {
        if(computedFacttill>=n) {
            return fact[n];
        }
        for(int i=computedFacttill+1;i<=n;i++) {
            fact[i] = fact[i-1].multiply(new BigInteger(Integer.toString(i)));
        }
        computedFacttill=n;
        return fact[n];
    }

    static BigInteger rank(int[] arr) {
/*
5
1 3 4 5 2
ans: 10
6
1 5 3 2 4 6
ans: 79
*/
        BigInteger rank = new BigInteger("1");
        for(int i=0; i<arr.length;i++) {
            int count=0;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j]<arr[i]) count++;
            }
            if(count>0) {
                BigInteger b1 = new BigInteger(Integer.toString(count));
                BigInteger b2 = computeFact(arr.length-i-1);
                rank = rank.add(b1.multiply(b2));
            }
        }
        return rank;
    }

    static BigInteger solve(int[] x, int numZeroes) {
        if(numZeroes==0) {
            BigInteger answer = rank(x).mod(new BigInteger("1000000007"));
            return answer;
        }
        HashMap<Integer, Integer> missing = new HashMap<>();
        int indexOfFirstZero = -1;
        for(int i=0;i<x.length;i++) {
            if(x[i]==0 && indexOfFirstZero==-1) indexOfFirstZero=i;
            missing.put(i+1,i+1);
        }
        for(int i=0;i<x.length;i++) {
            if(missing.containsKey(x[i])) {
                missing.remove(x[i]);
            }
        }
        int[] arr = new int[numZeroes];
        int index=0;
        for(int key:missing.keySet()) {
            arr[index++] = key;
        }
        BigInteger sum = new BigInteger("0");
        int[] tmp = x.clone();
        for(int i=0;i<arr.length;i++) {
            tmp[indexOfFirstZero]=arr[i];
            sum = sum.add(solve(tmp, numZeroes-1));
        }
        return sum;
    }

    public static void main(String[] args) {
        fact[0]=new BigInteger("1");
        fact[1]=new BigInteger("1");
        fact[2]=new BigInteger("2");
        computedFacttill=2;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int numZeroes = 0;
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            if(a[a_i]==0) numZeroes++;
        }
        BigInteger result = solve(a, numZeroes);
        System.out.println(result);
        in.close();
    }
}
