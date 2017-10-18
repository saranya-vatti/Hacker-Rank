package com.company;
import java.util.*;


public class Main {

    static String bonAppetit(int n, int k, int b, int[] ar) {
        int sum=0;
        for(int i=0;i<n;i++) {
            if(i!=k) {
                sum+=ar[i];
            }
        }
        int bactual = sum/2;
        if(bactual == b) return "Bon Appetit";
        else return Integer.toString(b-bactual);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        String result = bonAppetit(n, k, b, ar);
        System.out.println(result);
    }
}
