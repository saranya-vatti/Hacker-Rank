import java.io.*;
import java.util.*;

public class Solution {
    
    static int[] newLikes = new int[51];
    static int[] totalLikes = new int[51];
    
    static int newLike(int n) {
        if(newLikes[n] == 0 && n > 0) {
            newLikes[n] = (newLike(n-1) * 3) / 2;
            totalLikes[n] = totalLikes[n-1] + newLikes[n];
        }
        return newLikes[n];
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        newLikes[1] = 2; totalLikes[1] = 2;
        newLikes[2] = 3; totalLikes[2] = 5;
        newLikes[3] = 4; totalLikes[3] = 9;
        newLikes[4] = 6; totalLikes[4] = 15;
        newLikes[5] = 9; totalLikes[5] = 24;
        int tmp = newLike(n);
        System.out.println(totalLikes[n]);
    }
}