package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] ch=s.toCharArray();
        int count=1;
        for(int i=0;i<ch.length;i++) {
            if(Character.toUpperCase(ch[i]) == ch[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
