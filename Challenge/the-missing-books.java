import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int productOfPages(int a, int b, int c, int d, int p, int q) {
        if(a==p) {
            if(b==q) {
                return c*d;
            }
            if(c==q) {
                return b*d;
            }
            if(d==q) {
                return b*c;
            }
        }
        if(b==p) {
            if(a==q) {
                return c*d;
            }
            if(c==q) {
                return a*d;
            }
            if(d==q) {
                return a*c;
            }
        }
        if(c==p) {
            if(a==q) {
                return b*d;
            }
            if(b==q) {
                return a*d;
            }
            if(d==q) {
                return a*b;
            }
        }
        if(a==q) {
            return c*b;
        }
        if(c==q) {
            return a*b;
        }
        return a*c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            int answer = productOfPages(a, b, c, d, p, q);
            System.out.println(answer);
        }
        in.close();
    }
}
