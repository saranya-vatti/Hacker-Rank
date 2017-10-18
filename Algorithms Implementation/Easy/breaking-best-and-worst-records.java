package com.company;
import java.util.*;


public class Main {


    static int[] getRecord(int[] s){
        int best = s[0];
        int worst = s[0];
        int bestCounter=0, worstCounter=0;
        for(int i=1;i<s.length;i++) {
            if(s[i]>best) {
                bestCounter++;
                best = s[i];
            }
            if(s[i]<worst) {
                worstCounter++;
                worst = s[i];
            }
        }
        int[] result = {bestCounter, worstCounter};
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}
