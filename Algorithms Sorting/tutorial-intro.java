package com.company;
import java.util.*;
import java.io.*;
// Binary Search in Array
public class Main {

    private static int searchIndex(int[] arr, int V, int start, int end) {
        if(start == end) {
            return start;
        }
        if(start+1 == end) {
            if(V == arr[start]) {
                return start;
            } else if (V == arr[end]) {
                return end;
            }
        }
        int mid = (start+end)/2;
        if(V>arr[mid]) {
            return searchIndex(arr, V, mid+1, end);
        } else if(V<arr[mid]) {
            return searchIndex(arr, V, start, mid-1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int V = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(searchIndex(arr, V, 0, arr.length));
    }
}
