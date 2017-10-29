package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
20
34 57 34 9 31 61 12 93 5 24 21 32 16 98 28 99 59 84 65 27
10
1 8 11 97
2 15 15 15 20 911715175
2 1 10 2 6 855823464
2 8 16 17 20 887903056
1 17 20 75
1 18 18 77
2 17 18 2 20 919085426
2 1 2 7 10 493188378
2 4 9 18 19 823856468
2 13 17 17 19 354594618
 */

/*
10
52 71 9 92 54 44 21 40 78 12
4
1 4 4 77
1 3 3 30
1 10 10 44
2 7 7 4 10 2147483647
*/
/*
7
4 16 8 2 24 36 48
7
2 1 3 1 3 10
2 1 4 1 3 10
2 1 4 2 4 10
2 1 4 3 4 100
2 5 7 3 4 5000
2 3 7 2 4 500000
2 4 6 2 4 10
 */
public class Solution {

    private static int[] primesLessThanHun = {1,2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
    private static int numOfPrime = primesLessThanHun.length;
    private static BigInteger[][] powers = new BigInteger[numOfPrime][200];
    private static int MAX = 101;
    private static int[][] factorized = new int[MAX][numOfPrime];

    private static BigInteger power(int nIndex, int pow) {
        if(!powers[nIndex][pow].equals(BigInteger.ZERO)) return powers[nIndex][pow];
        int n = primesLessThanHun[nIndex];
        BigInteger b1 = new BigInteger(Integer.toString(n));
        if(pow <= 1) return b1;
        if(pow == 2) return b1.multiply(b1);
        if(pow%2==0) {
            BigInteger ans = power(nIndex, pow/2).multiply(power(nIndex, pow/2));
            powers[nIndex][pow] = ans;
//            System.out.println(primesLessThanHun[nIndex] + " to the power of " + pow + " = " + ans);
            return ans;
        }
        BigInteger ans = power(nIndex, pow - (pow/2)).multiply(power(nIndex, pow/2));
        powers[nIndex][pow] = ans;
//        System.out.println(primesLessThanHun[nIndex] + " to the power of " + pow + " = " + ans);
        return ans;
    }

    private static BigInteger product(int[] A, int start, int end) {
        int[] numerator = factorized[A[start]].clone();
        for(int index1=start+1;index1<=end;index1++) {
            int[] fact = factorized[A[index1]];
            for(int factIndex=0;factIndex<numOfPrime;factIndex++) {
                numerator[factIndex]+=fact[factIndex];
            }
        }
//        System.out.println("numerator = " + Arrays.toString(numerator));
        return solveNumDenArr(numerator);
    }

    private static BigInteger solve(int i, int j, int k, int l, int[] A) {
        if(i<k && k<j && j<l) {
            int tmp = j; // i,j; k,l
            j=k-1;
            k=tmp+1;
        } else if(k<i && i<l && l<j) {
            int tmp=l; // i,j; k,l
            l=i-1;
            i=tmp+1;
        } else if(k<i && j<=l) {
            return BigInteger.ZERO;
        } else if(i<k && l<j) {
            return product(A, i, k-1).multiply(product(A, l+1, j));
        } else if(j==l) {
            if(i<k) {
                j=k-1;
                return product(A, i, j);
            }
            return BigInteger.ONE;
        } else if(i==k) {
            if(j>l) {
                i = l+1;
                return product(A, i, j);
            }
            return BigInteger.ZERO;
        }
        int[] numerator = factorized[A[i]].clone();
        for(int index1=i+1;index1<=j;index1++) {
            int[] fact = factorized[A[index1]];
            for(int factIndex=0;factIndex<numOfPrime;factIndex++) {
                numerator[factIndex]+=fact[factIndex];
            }
        }
        int[] denominator = factorized[A[k]].clone();
        for(int index1=k+1;index1<=l;index1++) {
            int[] fact = factorized[A[index1]];
            for(int factIndex=0;factIndex<numOfPrime;factIndex++) {
                denominator[factIndex]+=fact[factIndex];
                if(denominator[factIndex]>numerator[factIndex]) {
                    return BigInteger.ZERO;
                }
            }
        }
        return solveNumDenArr(numerator, denominator);
    }

    private static BigInteger solveNumDenArr(int[] numerator) {
        BigInteger pij=BigInteger.ONE;
        for(int index=1;index<numOfPrime;index++) {
            if(numerator[index] >0) pij = pij.multiply(power(index, numerator[index]));
        }
        return pij;
    }

    private static BigInteger solveNumDenArr(int[] numerator, int[] denominator) {
        int[] num = new int[numOfPrime];
        for(int index=1;index<numOfPrime;index++) {
            if(numerator[index]>denominator[index]) {
                num[index] = numerator[index]-denominator[index];
            } else if(numerator[index]<denominator[index]) {
                return BigInteger.ZERO;
            } else {
                num[index]=0;
            }
        }
        return solveNumDenArr(num);
    }

    public static void main(String[] args) {
        for(int i=1;i<factorized.length;i++) {
            int num=i;
            factorized[i][0]=1;
            for(int j=1;num>1 && j<primesLessThanHun.length;j++) {
                factorized[i][j]=0;
                int primeDivisor=primesLessThanHun[j];
                while(num%primeDivisor==0) {
                    factorized[i][j]++;
                    num=num/primeDivisor;
                }
            }
        }
        for(int i=0;i<powers.length;i++) {
            for(int j=0;j<powers[i].length;j++) {
                powers[i][j]=BigInteger.ZERO;
            }
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n+1];
        for(int A_i = 1; A_i <= n; A_i++){
            A[A_i] = in.nextInt();
        }
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int type = in.nextInt();
//            System.out.println(Arrays.toString(A));
            if(type == 1) {
                int i=in.nextInt();
                int j=in.nextInt();
                int x = in.nextInt();
                for(int index=i;index<=n && index<=j;index++) {
                    A[index]=x;
                }
            } else {
                int i=in.nextInt();
                int j=in.nextInt();
                int k = in.nextInt();
                int l = in.nextInt();
                int m = in.nextInt();
//                try {
                    BigInteger ans = solve(i,j,k,l,A);
                    if(!ans.equals(BigInteger.ZERO)) {
                        System.out.println(ans.mod(new BigInteger(Integer.toString(m))));
                    } else {
                        System.out.println(-1);
                    }
//                } catch(Exception e) {
//                    System.out.println("Error for : " + i + ", " + j + ", " + k + ", " + l);
//                    e.printStackTrace();
//                }
            }
        }
        in.close();
    }
}
