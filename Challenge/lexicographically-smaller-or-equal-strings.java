import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] z = new String[n+1];
        for(int z_i = 1; z_i <= n; z_i++){
            z[z_i] = in.next();
        }
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int l = in.nextInt();
            int r = in.nextInt();
            String s = in.next();
            int count=0;
            for(int i=l;i<=r;i++) {
                if(s.compareTo(z[i]) >= 0) count++;
            }
            System.out.println(count);
        }
        in.close();
    }
}
