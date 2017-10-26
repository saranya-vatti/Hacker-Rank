package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(m == 1 || n%2 == 0 ? 2 : 1);
        }
    }
}