import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=1;i<=n;i++) {
            if(i%15 == 0) {
                System.out.println("FizzBuzz");
            } else if(i%3 == 0) {
                System.out.println("Fizz");
            } else if(i%5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}