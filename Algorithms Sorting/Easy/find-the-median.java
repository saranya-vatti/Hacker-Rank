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
        StringBuilder result = new StringBuilder("");
        result.append(arr[arr.length/2]);
        System.out.println(result);
    }
}
