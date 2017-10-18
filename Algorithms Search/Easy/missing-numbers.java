package com.company;
import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        int minA=Integer.MAX_VALUE;
        int maxA = 0;
        for(int i=0;i<n;i++) {
            A[i] = in.nextInt();
            if(minA>A[i]) {
                minA = A[i];
            }
            if(maxA<A[i]) {
                maxA = A[i];
            }
        }
        int m = in.nextInt();
        int[] B = new int[m];
        int minB=Integer.MAX_VALUE;
        int maxB = 0;
        for(int i=0;i<m;i++) {
            B[i] = in.nextInt();
            if(minB>B[i]) {
                minB = B[i];
            }
            if(maxB<B[i]) {
                maxB = B[i];
            }
        }
        int[] Acounter = new int[Math.max(maxA, maxB) - Math.min(minA, minB)+1];
        for(int i=0;i<Acounter.length;i++) {
            Acounter[i]=0;
        }
        for(int i=0;i<n;i++) {
            Acounter[A[i]-Math.min(minA, minB)]++;
        }

        int[] Bcounter = new int[Math.max(maxA, maxB) - Math.min(minA, minB)+1];
        for(int i=0;i<Bcounter.length;i++) {
            Bcounter[i]=0;
        }
        for(int i=0;i<m;i++) {
            Bcounter[B[i]-Math.min(minA, minB)]++;
        }
        for(int i=0;i<Bcounter.length;i++) {
            if(Bcounter[i]!=Acounter[i]) {
                System.out.print((i+Math.min(minA, minB))+ " ");
            }
        }
    }
}
