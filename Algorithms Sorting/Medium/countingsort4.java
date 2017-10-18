package com.company;

import java.util.*;
import java.io.*;
// Counting Sort with I/O handling
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(in.readLine());
        int[] count = new int[100];
        HashMap<Integer, Queue<String>> map= new HashMap<>();
        int maxValue=-1;
        for(int i=0;i<count.length;i++) {
            map.put(i, new LinkedList<>());
        }
        for(int i=0;i<s;i++){
            String[] tmp = in.readLine().split(" ");
            int tmpint = Integer.parseInt(tmp[0]);
            if(tmpint>maxValue) maxValue = tmpint;
            String tmpstr = tmp[1];
            count[tmpint]++;
            if(i<s/2) {
                map.get(tmpint).add("-");
            } else {
                map.get(tmpint).add(tmpstr);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count.length; i++) {
            for (String val : map.get(i)) {
                sb.append(val + " ");
            }
        }
        System.out.println(sb);
    }
}
