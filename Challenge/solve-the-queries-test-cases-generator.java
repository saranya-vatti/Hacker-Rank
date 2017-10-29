package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        int n = 10; // 50000;
        int q = 4; // 100000;
        BufferedWriter writer = new BufferedWriter(new FileWriter("testcases-solve-the-queries.txt"));
        String output = n+"\n";
        for(int i=0;i<n;i++) {
            Random rand = new Random();
            int  arrayElement = rand.nextInt(100) + 1;
            output += arrayElement + " ";
        }
        output = output + "\n" + q + "\n";
        for(int index=0;index<q;index++) {
            Random rand = new Random();
            int type = rand.nextInt(2) + 1;
            if(type==1) {
                int i = rand.nextInt(n) + 1;
                int j = (rand.nextInt(n-i+1)+1)+i-1;
                int x = rand.nextInt(100) + 1;
                output = output + type + " " + i + " " + j + " " + x + "\n";
            } else {
                int i = rand.nextInt(n) + 1;
                int j = (rand.nextInt(n-i+1)+1)+i-1;
                int k = rand.nextInt(n) + 1;
                int l = (rand.nextInt(n-k+1)+1)+k-1;
//                int m = rand.nextInt(1000000000) + 2;
                int m = Integer.MAX_VALUE;
                output = output + type + " " + i + " " + j + " " + k + " " + l + " " + m + "\n";
            }
        }
        writer.write(output);
        writer.close();
    }
}
