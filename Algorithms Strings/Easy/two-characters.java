package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// 187
// tlymrvjcylhqifsqtyyzfaugtibkkghfhyzxqbsizkjguqlqwwetyofqihtpkmpdlgthfybfhhmjerjdkybwppwrdapirukcshkpngayrdruanjtziknnwxmsjpnuswllymhkmztsrcwwzmlbcoakswwffveobbvzinkhnmvwqhpfednhsuzmffaebi
// 0


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        char[] sArr = s.toCharArray();
        char[] counter = new char[26];
        for(int i=0;i<counter.length;i++) {
            counter[i]=0;
        }
        for(int i=0;i<len;i++) {
            counter[sArr[i]-'a']++;
        }
        int maxlen=0;
        for(int i=0;i<counter.length-1;i++) {
            if(counter[i] != 0) {
                for(int j=i+1; j<counter.length;j++) {
                    if(counter[j]!=0) {
                        char c1 = (char)(i+'a');
                        char c2 = (char)(j+'a');
//                        System.out.println("Checking " + c1 + " and " + c2);
                        int start = Math.min(s.indexOf(c1), s.indexOf(c2));
                        char prev = sArr[start];
//                        System.out.println("prev = " + prev);
                        int l=1;
                        boolean broken = false;
                        for(int k=start+1;k<sArr.length;k++) {
//                            System.out.println("sArr[k] = " + sArr[k]);
//                            System.out.println("prev = " + prev);
                            if(sArr[k] == c1 && prev == c1) {
                                broken = true;
                                break;
                            }
                            if(sArr[k]==c2 && prev == c2) {
                                broken = true;
                                break;
                            }
                            if(sArr[k] == c1 && prev == c2) {
                                prev = c1;
                                l++;
//                                System.out.println("l = " + l);
                            }
                            if(sArr[k] == c2 && prev == c1) {
                                prev = c2;
                                l++;
//                                System.out.println("l = " + l);
                            }
                        }
                        if(maxlen<l && !broken) maxlen = l;
//                        System.out.println("maxlen = " + maxlen);
                    }
                }
            }
        }
        System.out.println(maxlen);
    }
}
