package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] ss = new int[m];
        for(int i=0;i<m;i++) {
            ss[i] = in.nextInt();
        }
        Arrays.sort(ss);
        int diff = 2*ss[0];
        if(m>1) {
            for(int i=1;i<m;i++) {
                if(diff<ss[i]-ss[i-1]) {
                    diff = ss[i]-ss[i-1];
                }
            }
        }
        if(diff<2*(n-ss[m-1]-1)) {
            diff = 2*(n-ss[m-1]-1);
        }
        System.out.println(diff/2);
    }
}
