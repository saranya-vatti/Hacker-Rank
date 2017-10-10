package com.company;

import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(in.readLine());
        String[] tmp = in.readLine().split(" ");
        int[] arr = new int[s];
        for(int i=0;i<s;i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(arr);
        int mindiff = Integer.MAX_VALUE;
        StringBuilder result = new StringBuilder("");
        for(int i=0;i<arr.length-1;i++) {
            int diff = arr[i+1]-arr[i];
            if(mindiff>=diff) {
                if(mindiff > diff) {
                    result.setLength(0);
                    mindiff = diff;
                }
                result.append(arr[i] + " " + arr[i+1] + " ");
            }
        }
        System.out.println(result);
    }
}
