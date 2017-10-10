package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            char[] hackerrank = {'h','a','c','k','e','r','r','a','n','k'};
            String answer = "";
            if (s.length() < hackerrank.length) {
                System.out.println("NO");
            } else {
                int hcounter = 0;
                char[] str = s.toCharArray();
                for(int i=0;i<str.length;i++) {
                    if(hcounter>=hackerrank.length) {
                        answer = "NO";
                        break;
                    } else if(str[i]==hackerrank[hcounter]) {
                        hcounter++;
                    }
                }
                if(hcounter==hackerrank.length) {
                    answer = "YES";
                }
                if(answer.equals("")) {
                    answer="NO";
                }
                System.out.println(answer);
            }
        }
    }
}
