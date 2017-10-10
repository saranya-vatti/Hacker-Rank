package com.company;
import java.util.*;

public class Main {

    static boolean isAnagram(String str1, String str2) {
        if(str1.length()!=str2.length()) {
            return false;
        }
        if(str1.length()==1) {
            return str1.equals(str2);
        }
        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];
        for(int i=0;i<str1.length();i++) {
            alpha1[str1.charAt(i)-'a']++;
            alpha2[str2.charAt(i)-'a']++;
        }
        for(int i=0;i<alpha1.length;i++) {
            if(alpha1[i]!=alpha2[i]) return false;
        }
        return true;
    }

    static int sherlockAndAnagrams(String s){
        int counter=0;
        for(int substrlen=1;substrlen<s.length();substrlen++) {
            String[] arr = new String[s.length()-substrlen + 1];
            int arrindex=0;
            for(int startsubstr = 0;startsubstr+substrlen-1<s.length();startsubstr++) {
                int endsubstr=substrlen+startsubstr-1;
                arr[arrindex++]=s.substring(startsubstr, endsubstr+1);
            }
            for(int i=0;i<arr.length-1;i++) {
                for(int j=i+1;j<arr.length;j++) {
                    if (isAnagram(arr[i],arr[j])) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
}
