package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int m = in.nextInt();
            if(a==b || m-a == b-m) {
                System.out.println("Mouse C");
            } else if (a==m) {
                System.out.println("Cat A");
            } else if(b==m) {
                System.out.println("Cat B");
            } else if(a<b && b<m) {
                System.out.println("Cat B");
            } else if(a<m && m<b) {
                if(b-m > m-a) {
                    System.out.println("Cat A");
                } else {
                    System.out.println("Cat B");
                }
            } else if(m<a && a<b) {
                System.out.println("Cat A");
            } else if(m<b && b<a){
                System.out.println("Cat B");
            } else if(b<a && a<m) {
                System.out.println("Cat A");
            } else if(b<m && m<a){
                if(a-m > m-b) {
                    System.out.println("Cat B");
                } else {
                    System.out.println("Cat A");
                }
            }
        }
    }
}
