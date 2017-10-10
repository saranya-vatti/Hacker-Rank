package com.company;

import java.util.*;
public class Main {
    static String timeConversion(String s) {
        String result = "";
        if (s.charAt(8) == 'A') {
            if(s.charAt(0) == '1' && s.charAt(1) == '2') {
                result += "00";
            } else {
                result += s.substring(0,2);
            }
        } else {
            if(s.charAt(0) == '1' && s.charAt(1) == '2') {
                result += "12";
            } else {
                result += Integer.parseInt(s.substring(0,2)) + 12;
            }
        }
        result += s.substring(2,8);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
