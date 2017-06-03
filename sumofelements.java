import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for(int a_i=0; a_i < n; a_i++){
            sum += in.nextInt();
        }
        System.out.println(sum);
    }
}