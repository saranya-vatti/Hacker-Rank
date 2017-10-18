package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int jumps = 0;
        int curr=0;
        for(curr=0;curr<=n-3;) {
            if(c[curr+2] == 0) {
                curr=curr+2;
                jumps++;
            } else {
                curr=curr+1;
                jumps++;
            }
        }
        if(curr==n-2) {
            jumps++;
        }
        System.out.println(jumps);
    }
}
