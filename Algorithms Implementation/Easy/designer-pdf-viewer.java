package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i=0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        char[] arr = word.toCharArray();
        int tallest = 0;
        for(int i=0;i<arr.length;i++) {
            if(tallest<h[arr[i]-'a']) tallest = h[arr[i]-'a'];
        }
        System.out.println(arr.length*tallest);
    }
}
