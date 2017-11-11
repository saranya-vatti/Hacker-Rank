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
        if(num<=2) return 0;
        int count = 0;
        long num8 = 8*num;
        for (int i=1;i<=num/2;i++) {
            long check = ((2*i -1)*(2*i -1)) + num;
            long sqrt = (long)(Math.sqrt(check));
            if (Math.pow(sqrt, 2) == check) {
                System.out.println(i);
                count++;
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
