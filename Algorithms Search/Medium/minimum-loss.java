package com.company;
import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] p = new long[n];
        for(int i=0;i<n;i++) {
            p[i]=in.nextLong();
        }
        long[] pSorted = p.clone();
        Arrays.sort(pSorted);
        HashMap<Long, Integer> sortedIndexes = new HashMap<>();
        HashMap<Long, Integer> origIndexes = new HashMap<>();
        for(int i=0;i<n;i++){
            sortedIndexes.put(pSorted[i], i);
            origIndexes.put(p[i], i);
        }
        long minloss = Long.MAX_VALUE;
        for(int i=0;i<n;i++) {
            // if we buy when price is least, we cannot sell
            if(sortedIndexes.get(p[i]) > 0) {
                for(int sortedIndex=sortedIndexes.get(p[i])-1; sortedIndex>=0;sortedIndex--) {
                    // Can only sell after the current year
                    if (origIndexes.get(pSorted[sortedIndex]) > i) {
                        long loss = p[i] - pSorted[sortedIndex];
                        if(minloss>loss) minloss = loss;
                        break;
                    }
                }
            }
        }
        System.out.println(minloss);
    }
}