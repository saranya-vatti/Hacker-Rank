package com.company;
import java.util.*;


public class Main {

    static int anagram(String s){
        char[] arr = s.toCharArray();
        int[] s1freq = new int[26];
        int[] s2freq = new int[26];
        for(int i=0;i<s1freq.length;i++) {
            s1freq[i]=0;
            s2freq[i]=0;
        }
        for(int i=0;i<s.length();i++) {
            if(s.length()%2==0) {
                if(i<=(s.length()/2)-1) {
                    s1freq[arr[i]-'a']++;
                } else {
                    s2freq[arr[i]-'a']++;
                }
            } else {
                return -1;
            }
        }
        int count=0;
        for(int i=0;i<s2freq.length;i++) {
            if(s2freq[i] > s1freq[i]) {
                count+=s2freq[i]-s1freq[i];
            } else if(s1freq[i]>s2freq[i]) {
                count+=s1freq[i]-s2freq[i];
            }
        }
        return count/2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagram(s);
            System.out.println(result);
        }
    }
}
