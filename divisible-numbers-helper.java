// 55, 99, 135, 165, 185, 198, 225, 235, 245, 275, 297, 315, 325, 342, 365, 385, 395, 396, 405, 425, 455, 475, 485, 495, 505, 525
// 24261 the answer was expected to be 15.
// 32 the expected answer is 4 and for 54 expected answer is 5

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.math.*;

public class Main {
    // for x = 1 to ininite
    // find the x digit numbers that have sum of the digits more than or eq to the prod
    //      start with all 1s, keep incrementing one digit
    //      then check the sum of the digits and the prod.
    //      when prod becomes higher than sum, break and statr incrementing other digit
    //      for each such number:
    //          start with the minimum number (with digits sorted in increasing order)
    //          check that the number % n =0. print if satisfies and break
    //          if not satisfying, check all permutations of those numbers

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] possible = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 22, 111, 119, 118, 117, 116, 115, 114, 113, 112, 123, 122, 1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118, 1119, 1121, 1122, 1123, 1124, 11111, 11112, 11113, 11114, 11115, 11118, 11119, 11116, 11117, 11123, 1117, 11122, 11125, 11124, 11133, 11222, 111133, 111126, 111125, 111124, 111123, 111122, 111118, 111119, 111116, 111117, 111114, 111115, 111112, 111113, 111111, 111222, 1111123, 1111122, 1111125, 1111124, 1111127, 1111126, 1111222, 1111133, 1111134, 1111111, 1111112, 1111113, 1111114, 1111115, 1111116, 1111117, 1111118, 1111119, 11111126, 11111127, 11111124, 11111125, 11111122, 11111123, 11111134, 11111133, 11111128, 11111111, 11111119, 11111118, 11111117, 11111116, 11111223, 11111115, 11111222, 11111114, 11111113, 11111112};
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=1000000;i<=10000000;i++) {
            String a =Integer.toString(i);
            char [] c = a.toCharArray();
            Arrays.sort(c);
            int tmp = Integer.parseInt(new String(c));
            int toPrint = Integer.parseInt(new String(c));
            int sum=0, prod=1;
            Boolean zero = false;
            for(int j=0;j<a.length();j++) {
                int dig = tmp%10;
                if(dig == 0) zero = true;
                sum += dig;
                prod *= dig;
                tmp = tmp/10;
            }
            if(sum>=prod && !zero) set.add(toPrint);
        }
        Iterator<Integer> itr=set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}