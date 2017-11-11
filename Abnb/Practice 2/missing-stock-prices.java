import java.io.*;
import java.util.*;
public class Solution {
    private static void calc(int N, double[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == -1) {
                if(i==0) {
                    System.out.println((2*arr[1])-arr[2]);
                } else if(i==arr.length-1) {
                    System.out.println((2*arr[i-1]) + arr[i-2]);
                } else {
                    System.out.println((arr[i-1]+arr[i+1])/2);
                }
            }
        }
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in).useDelimiter("/|\\s|:|\\t");
        int N = in.nextInt();
        double[] input = new double[N];
        for(int i=0;i<N;i++) {
            int month = in.nextInt(); // can be a param
            int day = in.nextInt(); // can be a param
            int year = in.nextInt();
            int hour = in.nextInt();
            int min = in.nextInt();
            int sec = in.nextInt();
            String record = in.next();
            if(record.indexOf("Missing_") != -1) {
                input[i] = -1;
            } else {
                input[i] = Double.parseDouble(record);
            }
        }
        
        if(in.hasNextLine()) {
            in.nextLine();
        }

        calc(N, input);
    }
}