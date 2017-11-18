import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = in.readLine().split(", ");
        int[] a = new int[arr.length];
        int sum = 0;
        for(int i=0;i<a.length;i++) {
            a[i] = Integer.parseInt(arr[i]);
            sum ^= a[i];
        }
        System.out.println(sum);
    }
}