package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    static String super_reduced_string(String s){
        s+='$';
        char[] ch=s.toCharArray();
        char prev = ch[0];
        char curr;
        int count=1;
        String answer = "";
        for(int i=1;i<ch.length;i++) {
            curr = ch[i];
            if(curr==prev) {
                count++;
            } else {
                if(count%2==1) {
                    answer+=prev;
                }
                count=1;
            }
            prev=curr;
        }
        if(answer.equals("")) {
            return "Empty String";
        }
        if(answer.length() < s.length()-1) {
            return super_reduced_string(answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
