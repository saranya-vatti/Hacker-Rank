import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] steps;
        steps = in.next().toCharArray();
        int[] height = new int[n+1];
        height[0]=0;
        for(int i=0;i<n;i++) {
            if(steps[i] == 'U') {
                height[i+1]=height[i]+1;
            } else {
                height[i+1]=height[i]-1;
            }
        }
        int counter=0;
        for(int i=1;i<=n;i++) {
            if(height[i]==0 && height[i-1]<0) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}