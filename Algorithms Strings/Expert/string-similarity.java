import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while(T-->0) {
            String str = in.readLine();
            char[] arr = str.toCharArray();
            char start = arr[0];
            long sum = arr.length;
            for(int j=1;j<arr.length;j++) {
                int origIndex = 0;
                while(origIndex < arr.length-j && arr[j+origIndex] == arr[origIndex]) {
                    origIndex++;
                }
                sum+=origIndex;
            }
            System.out.println(sum);
        }
    }
}