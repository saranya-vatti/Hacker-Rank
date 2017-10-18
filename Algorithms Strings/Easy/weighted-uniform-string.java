package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] sArr = s.toCharArray();
        int[] U = new int[s.length()];
        for(int i=0;i<U.length;i++) {
            U[i]=0;
        }
        U[0]=sArr[0]-'a'+1;
        int uCounter = 1;
        for(int i=1;i<sArr.length;i++) {
            int weight = sArr[i]-'a'+1;
            if(sArr[i]==sArr[i-1]) {
                U[uCounter] = U[uCounter-1] + weight;
            } else {
                U[uCounter] = weight;
            }
            uCounter++;
        }
        HashMap<Integer, Character> map = new HashMap<>();
        for(int i=0;i<U.length;i++) {
            map.put(U[i], (char)(i+'a'));
        }
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            if(map.containsKey(x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
