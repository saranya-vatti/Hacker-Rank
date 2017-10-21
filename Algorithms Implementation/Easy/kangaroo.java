package com.company;
import java.util.*;


public class Main {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x1 == x2) {
            return "YES";
        }
        if( x1 < x2 && v1 <= v2 ) {
            return "NO";
        }
        if( x2 < x1 && v2 <= v1 ) {
            return "NO";
        }
        int distDiff = x1>x2 ? x1-x2 : x2-x1;
        int velDiff = v1>v2 ? v1-v2 : v2-v1;
        if(distDiff%velDiff == 0) return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
s