package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int returnDay = in.nextInt();
        int returnMonth = in.nextInt();
        int returnYear = in.nextInt();
        int expectedDay = in.nextInt();
        int expectedMonth = in.nextInt();
        int expectedYear = in.nextInt();
        if(returnYear<expectedYear) {
            System.out.println(0);
        } else if(expectedYear<returnYear) {
            System.out.println(10000);
        } else if(returnMonth<expectedMonth) {
            System.out.println(0);
        } else if(expectedMonth<returnMonth) {
            System.out.println(500*(returnMonth-expectedMonth));
        } else if(returnDay < expectedDay) {
            System.out.println(0);
        } else if(expectedDay<returnDay) {
            System.out.println(15*(returnDay-expectedDay));
        } else {
            System.out.println(0);
        }
    }
}
