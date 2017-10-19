package com.company;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            int tmp = in.nextInt();
            map.put(tmp, i);
        }
        int count=0;
        for (int key : map.keySet()) {
            if(map.containsKey(key+d) && map.containsKey(key+d+d)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
