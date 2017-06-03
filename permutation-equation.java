import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] p = new int[51];
        int[] ans1 = new int[51];
        int[] ans2 = new int[51];
        for(int i=1;i<=n;i++){
            p[i] = scan.nextInt();
        }
        for(int i=1;i<=n;i++){
            ans1[i] = p[p[i]];
        }
        for(int i=1;i<=n;i++){
            ans2[ans1[i]] = i;
        }
        for(int x=1;x<=n;x++) {
            System.out.println(ans2[x]);
        }
    }
}
