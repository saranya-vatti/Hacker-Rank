import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    static BigInteger fact(int num) {
        BigInteger ans = new BigInteger("1");
        for(int i=2;i<=num;i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        System.out.println(fact(n));
    }
}