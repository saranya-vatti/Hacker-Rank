import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String ans = "-1";
        long price = Long.MAX_VALUE;
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            long currPrice = in.nextLong();
            long tmp = currPrice;
            if(currPrice < price) {
                boolean isValid = true;
                int count4 = 0;
                int count7 = 0;
                while(tmp!=0) {
                    if (tmp%10 == 4) count4++;
                    else if (tmp%10 == 7) count7++;
                    else {
                        isValid = false;
                        break;
                    }
                    tmp=tmp/10;
                }
                if(isValid && count4 == count7) {
                    price = currPrice;
                    ans = s;
                }
            }
        }
        System.out.println(ans);
        in.close();
    }
}
