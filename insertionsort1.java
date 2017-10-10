package com.company;
import java.util.*;
//Insert sort - beginner
public class Main {

    public static void insertIntoSorted(int[] ar) {
        if(ar.length==1) {
            printArray(ar);
            return;
        }
        int e = ar[ar.length-1];
        for(int i=ar.length-2;i>=0;i--) {
            if(ar[i]<=e) {
                ar[i+1] = e;
                printArray(ar);
                break;
            } else if(ar[i]>e) {
                ar[i+1] = ar[i];
                printArray(ar);
            }
        }
        if(ar[0]>e) {
            ar[0] = e;
            printArray(ar);
        }
    }


    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
