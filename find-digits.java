import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int digits[] = new int[10];
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(scan.nextLine());
            int tmp = n;
            int count = 0;
            while(tmp!=0) {
                if(tmp%10!=0 && n%(tmp%10) == 0) {
                    count++;
                }
                tmp = tmp/10;
            }
            System.out.println(count);
        }
    }
}