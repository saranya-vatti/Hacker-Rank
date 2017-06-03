import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static int min(int a, int b) {
        return a<=b ? a : b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        int diff = s.length() + t.length();
        for(int i=0;diff>1 && i<min(s.length(), t.length()) && s.charAt(i) == t.charAt(i); i++) {
            diff-=2;
        }
        if(diff > k) System.out.println("No");
        else if(diff%2 == k%2) System.out.println("Yes");
        else if(k>(s.length() + t.length())) System.out.println("Yes");
        else System.out.println("No");
    }
}
