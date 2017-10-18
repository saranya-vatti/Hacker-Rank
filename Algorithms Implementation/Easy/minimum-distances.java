package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int minDist = -1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i!=j) {
                    int dist = i-j;
                    if(dist<0) dist = -dist;
                    if((minDist == -1 || minDist>dist) && A[i] == A[j]) minDist = dist;
                }
            }
        }
        System.out.println(minDist);
    }
}
