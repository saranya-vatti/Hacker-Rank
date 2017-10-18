package com.company;
import java.util.*;


public class Main {

    static int theLoveLetterMystery(String s){
        int count = 0;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length/2;i++) {
            if(arr[i]<arr[arr.length-i-1]) {
                count = count + (arr[arr.length-i-1] - arr[i]);
            } else if(arr[i]>arr[arr.length-i-1]) {
                count = count + (arr[i] - arr[arr.length-i-1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = theLoveLetterMystery(s);
            System.out.println(result);
        }
    }
}
