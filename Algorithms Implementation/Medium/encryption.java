package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int L = str.length();
        double sqrt = Math.sqrt(L);
        int row=0, col=0;
        if((int)sqrt * (int)sqrt == L) {
            row = (int)sqrt;
            col = (int)sqrt;
        } else {
            int flr = (int)Math.floor(sqrt);
            int ceil = (int)Math.ceil(sqrt);
            row = flr;
            col = ceil;
            while(true) {
                row++;
                if(row*col >= L) {
                    break;
                }
                col++;
                if(row*col >= L) {
                    break;
                }
            }
        }
        for(int j=0;j<col;j++) {
            for(int i=0;i<row;i++) {
                if((i*col) + j <L) {
                    System.out.print(str.charAt((i*col) + j));
                }
            }
            System.out.print(' ');
        }
        System.out.println();
    }
}
