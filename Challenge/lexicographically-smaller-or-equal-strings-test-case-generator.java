package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        int n = 100005;
        int q = 100005;
        BufferedWriter writer = new BufferedWriter(new FileWriter("testcases.txt"));
        String output = n+"\n";
        for(int i=0;i<n;i++) {
            Random rand = new Random();
            int  strlen = rand.nextInt(15) + 1;
            String str = "";
            for(int j=0;j<strlen;j++) {
                String str2 = Character.toString((char)('a'+(rand.nextInt(26))));
                str +=str2;
            }
            output += str + "\n";
        }
        output += q + "\n";
        for(int i=0;i<q;i++) {
            Random rand = new Random();
            int l = rand.nextInt(n) + 1;
            int r = (rand.nextInt(n-l+1)+1)+l-1;
            int  strlen = rand.nextInt(15) + 1;
            String str = "";
            for(int j=0;j<strlen;j++) {
                String str2 = Character.toString((char)('a'+(rand.nextInt(26))));
                str +=str2;
            }
            output += l + " " + r + " " + str + "\n";
        }
        writer.write(output);
        writer.close();
    }
}
