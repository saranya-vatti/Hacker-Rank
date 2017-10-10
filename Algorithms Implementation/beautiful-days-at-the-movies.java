import java.io.*;
import java.util.*;

public class Solution {
    
    static int mod(int num) {
        if(num>=0) return num;
        return -num;
    }
    
    static int reversed(int num) {
        String str = Integer.toString(num);
        String out = "";
        for(int i=str.length()-1;i>=0;i--) {
            char c = str.charAt(i);
            out += c;
        }
        return Integer.parseInt(out);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        int j = scan.nextInt();
        int k = scan.nextInt();
        int count = 0;
        for(int p=i;p<=j;p++) {
            if((mod(reversed(p)-p)) % k == 0) count++;
        }
        System.out.println(count);
    }
}