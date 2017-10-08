package com.company;
import java.util.*;

public class Main {

    static int makingAnagrams(String s1, String s2){
        int deletions=0;
        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];
        for(int i=0;i<s1.length();i++) {
            alpha1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++) {
            alpha2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<alpha1.length;i++) {
            deletions+=Math.abs(alpha1[i]-alpha2[i]);
        }
        return deletions;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}
