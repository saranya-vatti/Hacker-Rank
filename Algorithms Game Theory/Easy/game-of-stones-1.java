package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean[] winners = new boolean[7];
        winners[0] = false;
        winners[1] = false;
        winners[2] = true;
        winners[3] = true;
        winners[4] = true;
        winners[5] = true;
        winners[6] = true;
        int t = in.nextInt();
        while(t-->0) {
            int n = in.nextInt();
            System.out.println(winners[n%7] ? "First" : "Second");
        }
    }
}