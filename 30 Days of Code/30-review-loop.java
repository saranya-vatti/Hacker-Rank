import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0) {
            String str = scan.next();
            for(int i=0;i<str.length();i+=2) {
                System.out.print(str.charAt(i));
            }
            System.out.print(" ");
            for(int i=1;i<str.length();i+=2) {
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }
    }
}