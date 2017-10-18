package com.company;
import java.util.*;


public class Main {

    static int solve(int n, int p){
        int fromStart, fromEnd;
        if(p%2 == 0) {
            fromStart = p/2;
            if(n%2==0) {
                fromEnd = (n-p)/2;
            } else {
                fromEnd = (n-p-1)/2;
            }
        } else {
            fromStart = (p-1)/2;
            if(n%2==0) {
                fromEnd = (n-p+1)/2;
            } else {
                fromEnd = (n-p)/2;
            }
        }
        return Math.min(fromStart, fromEnd);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
}
