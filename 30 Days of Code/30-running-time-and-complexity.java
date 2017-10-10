import java.io.*;
import java.util.*;
class Solution
{
    static void checkPrime (int n) {
        if (n==1) {
            System.out.println("Not prime");
            return;
        }
        if (n==2 || n==3 || n==5 || n==7 || n==11 || n==13) {
            System.out.println("Prime");
            return;
        }
        int sq = (int)Math.sqrt(n);
        for (int i=2;i <=sq;i++) {
            if(n%i==0) {
                System.out.println("Not prime");
                return;
            }
        }
        System.out.println("Prime");
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            checkPrime(ele);
        }
    }
}