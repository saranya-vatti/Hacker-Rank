package com.company;
import java.util.*;


public class Main {

    static int solve(int n, int[] s, int d, int m){
        if(m>n) return 0;
        if(n == m) {
            int sum=0;
            for(int i=0;i<n;i++) {
                sum+=s[i];
            }
            if(sum==d) return 1;
            return 0;
        }
        int counter=0;
        for(int i=0;i<=n-m;i++) {
            int sum=s[i];
            for(int j=i+1;j<i+m;j++) {
                sum+=s[j];
            }
            if(sum==d) counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
