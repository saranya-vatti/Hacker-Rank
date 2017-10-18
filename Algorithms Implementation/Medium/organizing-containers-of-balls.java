package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] M = new int[n][n];
            int[] sumOfCol = new int[n];
            int[] sumOfRow = new int[n];
            for (int i=0;i<sumOfCol.length;i++) {
                sumOfCol[i] = 0;
            }
            for(int M_i=0; M_i < n; M_i++){
                for(int M_j=0; M_j < n; M_j++){
                    M[M_i][M_j] = in.nextInt();
                    sumOfCol[M_j] += M[M_i][M_j];
                    sumOfRow[M_i] += M[M_i][M_j];
                }
            }
            Arrays.sort(sumOfCol);
            Arrays.sort(sumOfRow);
            String ans = "";
            for (int i=0;i<sumOfCol.length;i++) {
                if(sumOfCol[i] != sumOfRow[i]) {
                    ans = "Impossible";
                }
            }
            if(ans.equals("")) {
                System.out.println("Possible");
            } else {
                System.out.println(ans);
            }
        }
    }
}
