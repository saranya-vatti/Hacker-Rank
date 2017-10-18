package com.company;
import java.util.*;


public class Main {

    static String twoStrings(String s1, String s2){
        int[] s1arr = new int[26];
        char[] s1charr = s1.toCharArray();
        char[] s2charr = s2.toCharArray();
        for(int i=0;i<s1arr.length;i++) {
            s1arr[i]=0;
        }
        for(int i=0;i<s1charr.length;i++) {
            s1arr[s1charr[i]-'a']++;
        }
        for(int i=0;i<s2charr.length;i++) {
            if(s1arr[s2charr[i]-'a']!=0) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
    }
}
