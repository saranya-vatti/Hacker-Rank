package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        int num=0;
        for(int i=0;i<n;i++) {
            if(height[i]>k) {
                num += height[i]-k;
                k=height[i];
            }
        }
        System.out.println(num);
    }
}
