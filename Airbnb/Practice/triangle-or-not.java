// Name	Type	Description
// a	integer array	An array of n integers where each index i describes the length of side a // for triangle i.
// b	integer array	An array of n integers where each index i describes the length of side b for triangle i.
// c	integer array	An array of n integers where each index i describes the length of side c for triangle i.
// The function must return an array of n strings where the value at each index i is Yes if ai, bi, and ci can form a non-degenerate triangle; otherwise, it's No.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
    /*
     * Complete the function below.
     */
    static String[] triangleOrNot(int[] a, int[] b, int[] c) {
        String[] result = new String[a.length];
        for(int i=0;i<a.length;i++) {
            if(a[i]+b[i] > c[i] && b[i]+c[i] > a[i] && c[i]+a[i]>b[i]) {
                result[i] = "Yes";
            } else {
                result[i] = "No";
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String[] res;
        int a_size = 0;
        a_size = Integer.parseInt(in.nextLine().trim());

        int[] a = new int[a_size];
        for(int i = 0; i < a_size; i++) {
            int a_item;
            a_item = Integer.parseInt(in.nextLine().trim());
            a[i] = a_item;
        }

        int b_size = 0;
        b_size = Integer.parseInt(in.nextLine().trim());

        int[] b = new int[b_size];
        for(int i = 0; i < b_size; i++) {
            int b_item;
            b_item = Integer.parseInt(in.nextLine().trim());
            b[i] = b_item;
        }

        int c_size = 0;
        c_size = Integer.parseInt(in.nextLine().trim());

        int[] c = new int[c_size];
        for(int i = 0; i < c_size; i++) {
            int c_item;
            c_item = Integer.parseInt(in.nextLine().trim());
            c[i] = c_item;
        }

        res = triangleOrNot(a, b, c);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}

