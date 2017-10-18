package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer,String> minutes=new HashMap<Integer,String>();
        minutes.put(1, "one minute");
        minutes.put(2, "two minutes");
        minutes.put(3, "three minutes");
        minutes.put(4, "four minutes");
        minutes.put(5, "five minutes");
        minutes.put(6, "six minutes");
        minutes.put(7, "seven minutes");
        minutes.put(8, "eight minutes");
        minutes.put(9, "nine minutes");
        minutes.put(10, "ten minutes");
        minutes.put(11, "eleven minutes");
        minutes.put(12, "twelve minutes");
        minutes.put(13, "thirteen minutes");
        minutes.put(14, "fourteen minutes");
        minutes.put(15, "quarter");
        minutes.put(16, "sixteen minutes");
        minutes.put(17, "seventeen minutes");
        minutes.put(18, "eighteen minutes");
        minutes.put(19, "nineteen minutes");
        minutes.put(20, "twenty minutes");
        minutes.put(21, "twenty one minutes");
        minutes.put(22, "twenty two minutes");
        minutes.put(23, "twenty three minutes");
        minutes.put(24, "twenty four mintues");
        minutes.put(25, "twenty five minutes");
        minutes.put(26, "twenty six minutes");
        minutes.put(27, "twenty seven minutes");
        minutes.put(28, "twenty eight minutes");
        minutes.put(29, "twenty nine minutes");
        minutes.put(30, "half");
        HashMap<Integer,String> hours=new HashMap<Integer,String>();
        hours.put(1, "one");
        hours.put(2, "two");
        hours.put(3, "three");
        hours.put(4, "four");
        hours.put(5, "five");
        hours.put(6, "six");
        hours.put(7, "seven");
        hours.put(8, "eight");
        hours.put(9, "nine");
        hours.put(10, "ten");
        hours.put(11, "eleven");
        hours.put(12, "twelve");
        String ans = "";
        if(m == 0) {
            ans =hours.get(h) + " o' clock";
        } else if(m<=30) {
            ans = minutes.get(m) + " past " + hours.get(h);
        } else {
            ans = minutes.get(60-m) + " to " + hours.get(h+1);
        }
        System.out.println(ans);
    }
}
