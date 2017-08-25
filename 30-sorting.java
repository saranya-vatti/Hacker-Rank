import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static void swap(int[] a, int i, int j) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int numSwaps = 0;
        for(int i=0;i<n;i++) {
            int num = 0;
            for(int j=i+1;j<n;j++){
                if(a[i]>a[j]) {
                    swap(a,i,j);
                    num++;
                    numSwaps++;
                }
            }
            if (num == 0) {
                System.out.println("Array is sorted in " + numSwaps + " swaps.");
                System.out.println("First Element: " + a[0]);
                System.out.println("Last Element: " + a[n-1]);
                return;
            }
        }
        System.out.println("Array is sorted in " + numSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n-1]);
        return;
    }
}
