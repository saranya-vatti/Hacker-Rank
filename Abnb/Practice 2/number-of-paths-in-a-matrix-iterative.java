import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

      
        /*
         * Complete the function below.
         */
        static int numberOfPaths(int[][] a) {
            int totR = a.length;
            int totC = a[0].length;
            if(totR==1 && totC==1) return 1;
            long mod = (long)(Math.pow(10,9) + 7);
            long[][] numOfWays = new long[totR][totC];
            if(a[0][0]==1) numOfWays[0][0] = 1;
            else return 0;
            Queue<Integer> queueCol = new LinkedList<>();
            Queue<Integer> queueRow = new LinkedList<>();
            if(totC>1 && a[0][1] == 1) {
                queueRow.add(0);
                queueCol.add(1);
            }
            if(totR>1 && a[1][0] == 1) {
                queueRow.add(1);
                queueCol.add(0);
            }
            while(!queueCol.isEmpty()) {
                int row = queueRow.remove();
                int col = queueCol.remove();
                if(numOfWays[row][col] != 0) continue;
                if(row>0) numOfWays[row][col] = numOfWays[row-1][col];
                if(col>0) numOfWays[row][col] = (numOfWays[row][col] + numOfWays[row][col-1])%mod;
                if(row==totR-1 && col == totC-1) return (int)(numOfWays[row][col]%mod);
                if(col < totC-1 && a[row][col+1] == 1 && numOfWays[row][col+1] == 0) {
                    queueRow.add(row);
                    queueCol.add(col+1);
                }
                if(row < totR-1 && a[row+1][col] == 1 && numOfWays[row+1][col] == 0) {
                    queueRow.add(row+1);
                    queueCol.add(col);
                }
            }
            return (int)(numOfWays[totR-1][totC-1]%mod);
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
