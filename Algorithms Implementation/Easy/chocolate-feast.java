package com.company;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0) {
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            int totalChoc = n/c;
            int wrappersLeft = totalChoc;
            while(wrappersLeft>=m) {
                int chocBought = wrappersLeft/m;
                totalChoc = totalChoc + chocBought;
                wrappersLeft = chocBought + wrappersLeft%m;
            }
            System.out.println(totalChoc);
        }
    }
}
