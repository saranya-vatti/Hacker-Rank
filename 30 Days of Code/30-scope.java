import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
    private int[] elements;
    public int maximumDifference;
    Difference (int[] array) {
        elements = array;
    }

    public void computeDifference () {
        for ( int i=0;i<elements.length;i++) {
            for (int j=0; j<elements.length;j++) {
                int diff = (elements[i] >= elements[j]) ? elements[i]-elements[j] : elements[j]-elements[i];
                if (maximumDifference < diff) {
                    maximumDifference = diff;
                }
            }   
        }
    }
} // End of Difference class

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}