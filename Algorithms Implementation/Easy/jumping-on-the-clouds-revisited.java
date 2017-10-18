import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int delta = k%n;
        int end = 0;
        int energy = 100;
        if(end+delta >= n) System.out.println(energy);
        else {
            end = delta;
            energy--;
            if(c[end] == 1) energy-=2;
            while(end!=0) {
                end += delta;
                energy--;
                if(end>=n) end = 0;
                if(c[end] == 1) energy-=2;
            }
            System.out.println(energy);
        }
    }
}
