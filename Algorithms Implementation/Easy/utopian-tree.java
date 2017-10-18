package com.company;
import java.util.*;
public class Main {
    private static int[] height = new int[61];

    static int ht(int n){
        if(n <= 1) {
            return height[n];
        }
        if(height[n] != 0) {
            return height[n];
        }
        else {
            if(n%2!=0) {
                return 2*ht(n-1);
            }
            return ht(n-1) + 1;
        }
    }

    public static void main(String[] args) {
        height[0] = 1;
        height[1] = 2;
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            height[n] = ht(n);
            System.out.println(height[n]);
        }
    }
}
