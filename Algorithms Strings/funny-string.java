package com.company;
import java.util.*;

public class Main {

    static String funnyString(String s){
        char[] str = s.toCharArray();
        for(int i=1;i<str.length;i++) {
            int ascii = (int) str[i];
            int asciip = (int) str[i-1];
            int rascii = (int) str[str.length-i-1];
            int rasciip = (int) str[str.length-i];
            if (Math.abs(ascii-asciip) != Math.abs(rascii-rasciip)) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }
}
