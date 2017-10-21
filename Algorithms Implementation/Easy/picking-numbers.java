package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int maxCount=-1;
        Arrays.sort(a);
        for(int i=0;i<n-1;i++) {
            int currCount=1;
            for(int j=i+1;j<n && a[j]-a[i]<=1;j++) {
                currCount++;
            }
            if(maxCount<currCount) {
                maxCount = currCount;
            }
        }
        System.out.println(maxCount);
    }
}
