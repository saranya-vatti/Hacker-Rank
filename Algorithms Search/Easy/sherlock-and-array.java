package com.company;
import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main {

    static String solve(int[] a){
        if(a.length == 0 || a.length == 1) {
            return "YES";
        }
        if(a.length == 2 && (a[0] == 0 || a[1] == 0)) {
            return "YES";
        }
        int leftsum=0,rightsum=0;
        for(int i=0;i<a.length;i++) {
            rightsum+=a[i];
        }
        for(int i=0;i<a.length;i++) {
            leftsum += i==0 ? 0 : a[i-1];
            rightsum -= a[i];
//            System.out.println("leftsum : " + leftsum);
//            System.out.println("rightsum : " + rightsum);
            if(leftsum==rightsum) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}
