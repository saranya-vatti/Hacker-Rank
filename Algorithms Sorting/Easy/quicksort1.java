package com.company;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        Queue<Integer> left = new LinkedList<Integer>();
        Queue<Integer> equal = new LinkedList<Integer>();
        Queue<Integer> right = new LinkedList<Integer>();
        int pivot = ar[0];
        equal.add(pivot);
        for(int i=1;i<ar.length;i++) {
            if(ar[i]>pivot) {
                right.add(ar[i]);
            } else if(ar[i]<pivot) {
                left.add(ar[i]);
            } else {
                equal.add(ar[i]);
            }
        }
        for(int elem: left) {
            System.out.print(elem + " ");
        }
        for(int elem: equal) {
            System.out.print(elem + " ");
        }
        for(int elem: right) {
            System.out.print(elem + " ");
        }
        System.out.println("");
    }
}
