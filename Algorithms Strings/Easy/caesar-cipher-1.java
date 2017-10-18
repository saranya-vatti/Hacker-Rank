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
        String s = in.next();
        int k = in.nextInt();
        k=k%26;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if('a' <= arr[i] && arr[i] <= 'z') {
                char tmp = (char)(arr[i]+k);
                if(tmp>'z') {
                    System.out.print((char)(tmp-26));
                } else {
                    System.out.print(tmp);
                }
            } else if ('A' <= arr[i] && arr[i] <= 'Z') {
                char tmp = (char)(arr[i]+k);
                if(tmp>'Z') {
                    System.out.print((char)(tmp-26));
                } else {
                    System.out.print(tmp);
                }
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println();
    }
}
