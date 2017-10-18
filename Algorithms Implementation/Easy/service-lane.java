package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] service = new int[n];
        int t = in.nextInt();
        for(int i=0;i<n;i++) {
            service[i] = in.nextInt();
        }
        while(t-->0) {
            int entry = in.nextInt();
            int exit = in.nextInt();
            int min=4;
            for(int i=entry;i<=exit;i++) {
                if(min>service[i]) min=service[i];
            }
            System.out.println(min);
        }
    }
}
