package com.company;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[100];
        for(int i=0;i<s;i++){
            ar[in.nextInt()]++;
        }
        for(int i=0;i<ar.length;i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println();
    }
}
