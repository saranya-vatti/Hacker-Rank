package com.company;
import java.util.*;

public class Main {

    static String gameOfThrones(String s){
        char[] str = s.toCharArray();
        int[] alpha = new int[26];
        for(int i=0;i<str.length;i++) {
            alpha[str[i]-'a']++;
        }
        int oddCounter=0;
        for(int i=0;i<alpha.length;i++) {
            if(alpha[i]%2==1) {
                oddCounter++;
            }
            if(oddCounter>1) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
    }
}
