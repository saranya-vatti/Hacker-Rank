import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String w = in.next();
        char currChar, prevChar = w.charAt(0);
        Boolean isPrevVowel = false, isCurrVowel;
        if(prevChar == 'a' || prevChar == 'e' || prevChar == 'i' || prevChar == 'o' || prevChar == 'u' || prevChar == 'y') {
            isPrevVowel = true;
        }
        for(int i=1;i<w.length();i++) {
            currChar = w.charAt(i);
            isCurrVowel = false;
            if(currChar == 'a' || currChar == 'e' || currChar == 'i' || currChar == 'o' || currChar == 'u' || currChar == 'y') {
                isCurrVowel = true;
            }
            if((isPrevVowel && isCurrVowel) || prevChar == currChar) {
                System.out.println("No");
                return;
            } else {
                prevChar = currChar;
                isPrevVowel = isCurrVowel;
            }            
        }
        System.out.println("Yes");
    }
}
