package com.company;
import java.util.*;


public class Main {

    static int getMoneySpent(int[] keyboards, int[] drives, int s){
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        if(keyboards[0]+drives[0]>s) return -1;
        int kIndex=0, dIndex=drives.length-1;
        int currSum = -1;
        while(kIndex<keyboards.length && dIndex>=0) {
            int sum = keyboards[kIndex] + drives[dIndex];
            if(sum>s) {
                dIndex--;
            } else if(sum==s) {
                return s;
            } else {
                kIndex++;
            }
            if(currSum<sum && sum<s) currSum=sum;
        }
        return currSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}
