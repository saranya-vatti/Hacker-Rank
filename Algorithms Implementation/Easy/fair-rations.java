package com.company;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        int numOfOdd=0;
        for(int B_i=0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
            if(B[B_i]%2==1) {
                numOfOdd++;
            }
        }
        if(numOfOdd%2==1) System.out.println("NO");
        else {
            int count=0;
            for(int i = 0; i<N; i++) {
                if (B[i] % 2 != 0) {
                    B[i] = B[i] + 1;
                    B[i + 1] = B[i + 1] + 1;
                    count += 2;
                }
            }
            System.out.println(count);
        }
    }
}
