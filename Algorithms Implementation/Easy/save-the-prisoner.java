import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0;i<t;i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int s = scan.nextInt();
            if(m==0) {
                System.out.println(0);
            } else if ((m+s-1)%n == 0) {
                System.out.println(n);
            } else {
                System.out.println((m+s-1)%n);
            }
        }
    }
}