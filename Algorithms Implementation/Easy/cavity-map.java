package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[][] grid = new char[n][n];
        for(int grid_i=0; grid_i < n; grid_i++){
            String tmp = in.next();
            grid[grid_i] = tmp.toCharArray();
        }
        char[][] result = new char[n][n];
        for(int j=0;j<n;j++) {
            result[0][j]=grid[0][j];
            result[n-1][j]=grid[n-1][j];
            result[j][0]=grid[j][0];
            result[j][n-1]=grid[j][n-1];
        }
        for(int i=1;i<n-1;i++) {
            for(int j=1;j<n-1;j++) {
                if(grid[i][j]>grid[i-1][j] && grid[i][j]>grid[i][j-1] && grid[i][j]>grid[i+1][j] && grid[i][j]> grid[i][j+1]) {
                    result[i][j]='X';
                } else {
                    result[i][j]=grid[i][j];
                }
            }
        }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
