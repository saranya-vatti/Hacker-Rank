import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum1=0,sum2=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int tmp = in.nextInt();
                if(i==j) {
                    sum1+=tmp;
                }
                if (i+j==n-1) {
                    sum2+=tmp;
                }
            }
        }
        System.out.println(sum1-sum2>=0 ? sum1-sum2 : sum2-sum1);
    }
}