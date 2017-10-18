package com.company;
import java.util.*;


public class Main {
    static int gemstones(String[] arr){
        boolean[] old = new boolean[26];
        for(int i=0;i<old.length;i++) {
            old[i] = true;
        }
        for(int i=0;i<arr.length;i++) {
            char[] elemArr = arr[i].toCharArray();
            boolean[] curr = new boolean[26];
            for(int j=0;j<curr.length;j++) {
                curr[j]=false;
            }
            for(int j=0;j<elemArr.length;j++) {
                curr[elemArr[j]-'a'] = true;
            }
            for(int j=0;j<old.length;j++) {
                old[j] = old[j] && curr[j];
            }
        }
        int count = 0;
        for(int i=0;i<old.length;i++) {
            if(old[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr);
        System.out.println(result);
    }
}
