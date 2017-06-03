import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            int startIndex = k==0 ? 0 : n-(k%n);
            if(startIndex+m < n) {
                System.out.println(a[startIndex+m]);
            } else {
                System.out.println(a[(startIndex+m)%n]);
            }            
        }
    }
}
