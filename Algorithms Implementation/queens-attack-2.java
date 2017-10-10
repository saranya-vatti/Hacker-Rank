import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int max(int a, int b) {
        return a>=b?a:b;
    }
     public static int min(int a, int b) {
        return max(a<=b? a:b, 0);
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt();
        int cQueen = in.nextInt();
        int north = max(n-rQueen, 0);
        int south = max(rQueen-1,0);
        int east = max(n-cQueen,0);
        int west = max(cQueen-1,0);
        int northwest = min(north, west);
        int northeast = min(north, east);
        int southwest = min(south, west);
        int southeast = min(south, east);
        for(int a0 = 0; a0 < k; a0++){
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();
            if(rQueen == rObstacle) {
                if(cQueen<cObstacle) {
                    east = min(cObstacle-cQueen-1, east);
                } else if (cQueen>cObstacle){
                    west = min(cQueen-cObstacle-1, west);
                }
            }
            if(cQueen==cObstacle) {
                if(rQueen<rObstacle) {
                    north = min(rObstacle-rQueen-1, north);
                } else if(rQueen>rObstacle) {
                    south = min(rQueen-rObstacle-1, south);
                }
            }
            if (rObstacle>rQueen && cObstacle < cQueen && cQueen-cObstacle == rObstacle-rQueen) {
                northwest = min(cQueen-cObstacle-1, northwest);
            }
            if (rObstacle>rQueen && cObstacle > cQueen && cObstacle-cQueen == rObstacle-rQueen) {
                northeast = min(cObstacle-cQueen-1, northeast);
            }
            if (rObstacle<rQueen && cObstacle > cQueen && cObstacle-cQueen == rQueen-rObstacle) {
                southeast = min(cObstacle-cQueen - 1, southeast);
            }
            if (rObstacle<rQueen && cObstacle < cQueen && cQueen-cObstacle == rQueen-rObstacle) {
                southwest = min(cQueen-cObstacle - 1, southwest);
            }
        }
        System.out.println(north+northeast+east+southeast+south+southwest+west+northwest);
    }
}
