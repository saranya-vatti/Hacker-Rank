package com.company;
import java.util.*;


public class Main {

    static int getTotalX(int[] a, int[] b) {
        int counter=0;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=a[a.length-1];i<=b[0];i++) {
            boolean isDivisor = true, isFactor = true;
            for(int j=0;j<a.length;j++) {
                if(i%a[j]!=0) {
                    isDivisor = false;
                    break;
                }
            }
            for(int j=0;j<b.length;j++) {
                if(b[j]%i!=0) {
                    isFactor = false;
                    break;
                }
            }
            if(isFactor && isDivisor) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
