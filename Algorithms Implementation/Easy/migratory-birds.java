package com.company;
import java.util.*;


public class Main {

    static int migratoryBirds(int n, int[] ar) {
        int[] counter = new int[5];
        for(int i=0;i<5;i++) {
            counter[i]=0;
        }
        for(int i=0;i<n;i++) {
            counter[ar[i]-1]++;
        }
        int max = -1;
        int type=0;
        for(int i=0;i<5;i++) {
            if(max<counter[i]) {
                max=counter[i];
                type=i;
            }
        }
        return type+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
