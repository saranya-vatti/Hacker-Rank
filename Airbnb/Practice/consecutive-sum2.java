package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    /*
     * Complete the function below.
     */
    static int consecutive(long num) {
        // TLE >= approx 2*Integer.MAX
        if(num<=2) return 0;
        int count = 0;
        long low = 1;
        long high = 1;
        long sum = 1;
        while(low <= num/2) {
            if(sum<num) {
                high++;
                sum+=high;
            } else if(sum>num) {
                sum-=low;
                low++;
            } else {
                count++;
                sum-=low;
                low++;
            }
        }
        return count;
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
        long num;
        num = Long.parseLong(in.nextLine().trim());

        res = consecutive(num);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
