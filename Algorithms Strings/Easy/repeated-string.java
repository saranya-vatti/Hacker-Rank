package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        long count=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == 'a') {
                count++;
            }
        }
        count=count*(n/s.length());
        for(int i=0;i<n%s.length();i++) {
            if(s.charAt(i)=='a') count++;
        }
        System.out.println(count);
    }
}
