package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {

    public static void main(String[] args)throws IOException  {
        int T = 10; // 20
        int MAXN = 1000; // 100000
        int MAXM = (MAXN*(MAXN-1))/2;
        BufferedWriter writer = new BufferedWriter(new FileWriter
                ("testcases-bfsshortreach.txt"));
        StringBuilder input = new StringBuilder(T+"\n"+MAXN+" "+MAXM+"\n");
        for(int i=1;i<=MAXN;i++) {
            for(int j=1;j<=MAXN;j++) {
                input.append(i + " " + j + "\n");
            }
        }
        for(int i=0;i<T;i++) {
            Random rand = new Random();
            int  s = rand.nextInt(MAXN) + 1;
            input = input.append(s + "\n");
        }
        writer.write(input.toString());
        writer.close();
    }
}
