import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int acD=sc.nextInt();
        int acM=sc.nextInt();
        int acY=sc.nextInt();
        int exD=sc.nextInt();
        int exM=sc.nextInt();
        int exY=sc.nextInt();
        int fine=0;
        if(acY == exY) {
            if (acM == exM) {
                if (acD <= exD) {
                    fine = 0;
                } else {
                    fine = 15 * (acD-exD);
                }
            } else if (acM > exM) {
                fine = 500 * (acM-exM);
            } else if (acM < exM) {
                fine = 0;
            }
        } else if (acY > exY) {
            fine = 10000;
        } else if (acY < exY) {
            fine = 0;
        }
        System.out.println(fine);
    }
}