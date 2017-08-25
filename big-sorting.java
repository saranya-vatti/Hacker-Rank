// 55, 99, 135, 165, 185, 198, 225, 235, 245, 275, 297, 315, 325, 342, 365, 385, 395, 396, 405, 425, 455, 475, 485, 495, 505, 525
// 24261 the answer was expected to be 15 - 111151121111112
// 32 the expected answer is 4 and for 54 expected answer is 5

// int[] possible = {};
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.math.*;

public class Solution {

    /* low  --> Starting index,  high  --> Ending index */
    static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
        /* pi is partitioning index, arr[p] is now
           at right place */
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Before pi
            quickSort(arr, pi + 1, high); // After pi
        }
    }

    static boolean less(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return true;
        }
        if (str1.length() > str2.length()) {
            return false;
        }
        int index = 0;
        while (index <= (str1.length() - 1)) {
            char c1 = str1.charAt(index);
            char c2 = str2.charAt(index);
            if (c1 == c2) {
                index++;
            } else {
                return (Character.getNumericValue(c1) <= Character.getNumericValue(c2));
            }
        }
        return true; // they are same numbers
    }

    static void swap(String[] arr, int i, int j) {
        String tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    /* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
    static int partition (String[] arr, int low, int high) {
        // pivot (Element to be placed at right position)
        String pivot = arr[high];

        int i = (low - 1);  // Index of smaller element

        for (int j = low; j <= high- 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (less(arr[j], pivot)) {
                i++;    // increment index of smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        quickSort(unsorted, 0, n-1);
        for (int i=0; i<n;i++) {
            System.out.println(unsorted[i]);
        }
    }
}