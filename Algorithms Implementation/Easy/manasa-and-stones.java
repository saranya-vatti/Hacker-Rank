package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int prev=-1, curr=-2;
            for(int i=0;i<=n-1;i++) {
                curr = (i*Math.max(a,b)) + ((n-i-1)*Math.min(a,b));
                if(curr == prev) {
                    break;
                }
                System.out.print(curr + " ");
                prev=curr;
            }
            System.out.println();
        }
    }
}
