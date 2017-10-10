package com.company;
import java.util.*;
// aabbcc = YES
// baacdd = NO
// aabbccc = YES
// aabbc = YES
// abcccc = NO
// abccc = NO
// abcddd = NO
// abcccc = NO
// aaabbbcc = NO
// abcccc = NO
// abbac = YES
// abcd = YES
// aaabbbcccddde = YES
// aaabbbccddee = NO
// aaaabbbbcc = NO

public class Main {

    static String isValid(String s){
        char[] str = s.toCharArray();
        int[] alpha = new int[26];
        for(int i=0;i<str.length;i++) {
            alpha[str[i]-'a']++;
        }
        int min=100005,max=-1;
        for(int i=0;i<alpha.length;i++) {
            if(min>=alpha[i] && alpha[i]!=0) min=alpha[i];
            if(max<=alpha[i]) max=alpha[i];
        }
        for(int i=0;i<alpha.length;i++) {
            if(alpha[i]!=max && alpha[i]!=min && alpha[i]!=0) {
                return "NO";
            }
        }
        if(max==min) return "YES";
        int maxCounter=0, minCounter=0;
        for(int i=0;i<alpha.length;i++) {
            if(max==alpha[i]) {
                maxCounter++;
            } else if (min==alpha[i]) {
                minCounter++;
            }
        }
        if(minCounter>maxCounter && maxCounter>1) {
            return "NO";
        }
        if(maxCounter>minCounter && minCounter>1) {
            return "NO";
        }
        if(maxCounter == minCounter && minCounter>1) {
            return "NO";
        }
        if(max-min>1 && minCounter >1) return "NO";
        if(maxCounter>1 && min>1) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
