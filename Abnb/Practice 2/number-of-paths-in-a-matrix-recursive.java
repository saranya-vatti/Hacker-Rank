import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

        static int numberOfPaths(int[][] a, int totR, int totC) {
            if(totR == 0 && totC == 0) return 1;
            long mod = (long)(Math.pow(10,9) + 7);
            long sum = 0;
            if(totR>0 && a[totR-1][totC]==1) {
                sum = (sum+numberOfPaths(a, totR-1, totC))%mod;
            }
            if(totC>0 && a[totR][totC-1]==1) {
                sum = (sum+numberOfPaths(a, totR, totC - 1))%mod;
            }
            return (int)(sum%mod);
        }
        /*
         * Complete the function below.
         */
        static int numberOfPaths(int[][] a) {
            int totR = a.length;
            int totC = a[0].length;
            if(totR==1 && totC==1) return 1;
            return numberOfPaths(a, totR-1, totC-1);
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

        int res;
        int a_rows = 0;
        int a_cols = 0;
        a_rows = Integer.parseInt(in.nextLine().trim());
        a_cols = Integer.parseInt(in.nextLine().trim());

        int[][] a = new int[a_rows][a_cols];
        for(int a_i = 0; a_i < a_rows; a_i++) {
            for(int a_j = 0; a_j < a_cols; a_j++) {
                a[a_i][a_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }

        res = numberOfPaths(a);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
