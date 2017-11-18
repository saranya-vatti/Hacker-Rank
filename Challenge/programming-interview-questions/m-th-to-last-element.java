import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(in.readLine());
        String[] arr = in.readLine().split(" ");
        int mIndex = 0;
        String mth = arr[mIndex];
        int len = 0;
        for(int index = 0;index<arr.length;index++) {
            if(len < m) { 
                len++;
            } else {
                // Screwed up input
                // supposed to be a linkedlist
                // so wrote it like linked list
                mIndex++;
                mth = arr[mIndex];
            }
        }
        if(len < m) {
            System.out.println("NIL");
        } else {
            System.out.println(mth);
        }
    }
}