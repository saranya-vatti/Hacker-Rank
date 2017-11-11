import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */
    static int[] stringSimilarity(String[] inputs) {
        int[] ans = new int[inputs.length];
        for(int i=0;i<inputs.length;i++) {
            char[] arr = inputs[i].toCharArray();
            char start = arr[0];
            int sum = arr.length;
            for(int j=1;j<arr.length;j++) {
                int origIndex = 0;
                int currIndex = j;
                while(origIndex < arr.length && currIndex < arr.length && arr[currIndex] == arr[origIndex]) {
                    origIndex++;
                    currIndex++;
                    sum++;
                }
            }
            ans[i] = sum;
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

        int[] res;
        int inputs_size = 0;
        inputs_size = Integer.parseInt(in.nextLine().trim());

        String[] inputs = new String[inputs_size];
        for(int i = 0; i < inputs_size; i++) {
            String inputs_item;
            try {
                inputs_item = in.nextLine();
            } catch (Exception e) {
                inputs_item = null;
            }
            inputs[i] = inputs_item;
        }

        res = stringSimilarity(inputs);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}
