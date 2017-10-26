package com.company;
import java.util.*;
// https://math.stackexchange.com/questions/416042/why-xor-operator-works
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        while(g-->0) {
            int n = in.nextInt();
            int tmp=in.nextInt();
            for(int i=0;i<n-1;i++) {
                tmp = tmp^in.nextInt();
            }
            if(tmp == 0) {
                System.out.println("Second");
            } else {
                System.out.println("First");
            }
        }
    }
}