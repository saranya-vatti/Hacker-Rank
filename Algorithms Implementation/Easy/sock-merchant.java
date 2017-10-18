package com.company;
import java.util.*;


public class Main {

    static int sockMerchant(int n, int[] ar) {
        int[] color = new int[101];
        for(int i=0;i<n;i++) {
            color[i]=0;
        }
        for(int i=0;i<ar.length;i++) {
            color[ar[i]]++;
        }
        int counter = 0;
        for(int i=1;i<color.length;i++) {
            counter = counter + (color[i]/2);
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
