package com.company;

import java.util.*;
import java.io.*;
public class Main {
    static int birthdayCakeCandles(int n, int[] ar) {
        int tallest=-1, tallestCounter=0;
        for(int i=0;i<n;i++) {
            if(tallest<ar[i]) {
                tallest=ar[i];
                tallestCounter=1;
            } else if(tallest==ar[i]){
                tallestCounter++;
            }
        }
        return tallestCounter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
