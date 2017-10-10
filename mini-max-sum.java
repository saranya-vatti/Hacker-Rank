package com.company;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long sum=0;
        long min=Integer.MAX_VALUE;
        long max = 0;
        for(int i=0;i<5;i++) {
            long curr = in.nextInt();
            if(max<=curr) max = curr;
            if(min>=curr) min=curr;
            sum+=curr;
        }
        System.out.println((sum-max) + " " + (sum-min));
    }
}
