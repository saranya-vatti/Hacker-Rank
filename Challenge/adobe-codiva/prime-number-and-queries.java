import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    //int[] isPrime = new int[1000007];
    static int[] isPrime = new int[1000007];
    
    static void calc() {
        for(int i=0;i<isPrime.length;i++) {
            isPrime[i] = -1;
        }
        for(int i=2;i<isPrime.length;i++) {
            if(isPrime[i]==-1) {
                isPrime[i] = 1;
                if(i<(int)Math.sqrt(1000007)) {
                    for(int j=i*i;j<isPrime.length;j+=i) {
                        isPrime[j]=0;
                    }
                }
            }
        }
    }

    static int maxDifference(int startVal, int endVal) {
        if(startVal == endVal) return 0;
        int start=0; int end=0;
        for(int i=startVal;i<=endVal;i++) {
            if(isPrime[i] == 1) {
                start = i;
                break;
            }
        }
        for(int i=endVal;i>=startVal;i--) {
            if(isPrime[i] == 1) {
                end = i;
                break;
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        calc();
        /*for(int i=2;i<isPrime.length;i++) {
            System.out.println(i + ": " + isPrime[i]);
        }*/
        for(int a0 = 0; a0 < q; a0++){
            int startVal = in.nextInt();
            int endVal = in.nextInt();
            int result = maxDifference(startVal, endVal);
            System.out.println(result);
        }
        in.close();
    }
}
