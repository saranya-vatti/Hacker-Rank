package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        char[] arr = str.toCharArray();
        int counter = 0;
        for(int i=0;i<arr.length;i=i+3) {
            if(arr[i]!='S') {
                counter++;
            }
            if(arr[i+1]!='O') {
                counter++;
            }
            if(arr[i+2]!='S') {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
