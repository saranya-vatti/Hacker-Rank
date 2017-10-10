package com.company;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int m = Integer.parseInt(in.readLine());
            int n = Integer.parseInt(in.readLine());
            int[] c = new int[n];
            String[] tmp = in.readLine().split(" ");
            int[] indexarr = new int[1001];
            boolean solution = false;
            for(int i=0;i<1001;i++) {
                indexarr[i]=-1;
            }
            for(int i=0;i<tmp.length;i++) {
                c[i] = Integer.parseInt(tmp[i]);
                if(indexarr[c[i]] > -1 && c[i] == m/2 && m%2==0) {
                    System.out.println((indexarr[c[i]]+1) + " " + (i+1));
                    solution = true;
                }
                indexarr[c[i]] = i;
            }
            if(!solution) {
                Arrays.sort(c);
                int left = 0;
                int right = n-1;
                while(true) {
                    if(c[left]+c[right]>m) {
                        right--;
                    } else if(c[left]+c[right]<m) {
                        left++;
                    } else {
                        int index1 = indexarr[c[left]]+1;
                        int index2 = indexarr[c[right]]+1;
                        System.out.println( Math.min(index1, index2) + " " + Math.max(index1, index2));
                        break;
                    }
                }
            }
        }
    }
}
