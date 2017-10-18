package com.company;
import java.util.*;


public class Main {
    static int alternatingCharacters(String s){
        char[] sArr = s.toCharArray();
        int counter=0;
        for(int i=1;i<sArr.length;i++) {
            if(sArr[i]==sArr[i-1]) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
    }
}
