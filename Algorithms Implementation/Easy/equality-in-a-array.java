package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] counter = new int[101];
        for(int i=0;i<101;i++) {
            counter[i]=0;
        }
        int maxcounter = -1;
        for(int i=0;i<n;i++) {
            int tmp=in.nextInt();
            counter[tmp]++;
            if(maxcounter<counter[tmp]) maxcounter=counter[tmp];
        }
        System.out.println(n-maxcounter);
    }
}
