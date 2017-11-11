import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */
    static int maxStep(int n, int k) {
        int sqrt = (int)Math.sqrt(8*k + 1);
        int ans = (n*(n+1))/2;
        if(sqrt*sqrt == 8*k+1) {
            ans--;
        }
        return ans;
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
        int n;
        n = Integer.parseInt(in.nextLine().trim());

        int k;
        k = Integer.parseInt(in.nextLine().trim());

        res = maxStep(n, k);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
