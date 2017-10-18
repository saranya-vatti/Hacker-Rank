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
        int[] alpha = new int[26];
        int counter = 0;
        for(int i=0;i<alpha.length;i++) {
            alpha[i]=0;
        }
        boolean isPangram = false;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != ' ') {
                arr[i] = Character.toLowerCase(arr[i]);
                if(alpha[arr[i]-'a'] == 0) {
                    counter++;
                    if(counter==26) {
                        isPangram = true;
                        break;
                    }
                }
                alpha[arr[i]-'a']++;
            }
        }
        if(isPangram) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }
}
