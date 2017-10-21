package com.company;
import java.util.*;


public class Main {

    static boolean isHappy(String b) {
        if(b.length()==1 && b.charAt(0) != '_') return false;
        int lenWithUn = b.length();
        b=b.replaceAll("_", "");
        if(b.length()==0) return true;
        if(b.length()==1) return false;
        boolean isUnderscorePresent = lenWithUn > b.length();
        char[] arr = b.toCharArray();
        if(isUnderscorePresent) {
            Arrays.sort(arr);
        }
        if(arr[0] != arr[1]) return false;
        if(arr[arr.length-2] != arr[arr.length-1]) return false;
        for(int i=1;i<arr.length-1;i++) {
            if(arr[i-1] != arr[i] && arr[i] != arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            int n = in.nextInt();
            String b = in.next();
            if(isHappy(b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
