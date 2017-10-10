import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int pos=0,neg=0,zero=0;
        double posfrac,negfrac,zerofrac;
        for(int i=0;i<n;i++) {
            int tmp = in.nextInt();
            if(tmp>0) {
                pos++;
            } else if(tmp<0) {
                neg++;
            } else {
                zero++;
            }
        }
        posfrac = (double)pos/n;
        negfrac = (double)neg/n;
        zerofrac = (double)zero/n;
        System.out.println(posfrac);
        System.out.println(negfrac);
        System.out.println(zerofrac);
    }
}