package com.company;
import java.util.*;
//Insert sort - beginner
public class Main {

    public static void insertionSortPart2(int[] ar)
    {
        int numOfShifts = 0;
        for(int j=1;j<ar.length;j++) {
            int e = ar[j];
            for(int i=j-1;i>=0;i--) {
                if(ar[i]<=e) {
                    ar[i+1] = e;
                    break;
                } else if(ar[i]>e) {
                    ar[i+1] = ar[i];
                    numOfShifts++;
                }
            }
            if(ar[0]>e) {
                ar[0] = e;
            }
        }
        printArray(ar);
        System.out.println(numOfShifts);
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
