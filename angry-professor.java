import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int t, k, n, present, tmp;
        Scanner scan = new Scanner(System.in);
        t = Integer.parseInt(scan.nextLine());
        for(int i=0; i<t;i++) {
            n = scan.nextInt();
            k = scan.nextInt();
            present = 0;
            for(int j=0;j<n;j++){
                tmp = scan.nextInt();
                if(tmp<=0) present++;
            }
            if(present<k) System.out.println("YES");
            else System.out.println("NO");
        }
        
    }
}