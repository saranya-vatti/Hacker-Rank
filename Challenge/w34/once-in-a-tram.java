import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int sumOfDigits (int x) {
        int sum = 0;
        while(x!=0) {
            sum+=x%10;
            x=x/10;
        }
        return sum;
    }
    static String onceInATram(int x) {
        x++;
        while(sumOfDigits((int)(x/1000)) != sumOfDigits(x%1000)) {
            x++;
        }
        return Integer.toString(x);
    }

    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();
    String result = onceInATram(x);
    System.out.println(result);
    }
}
