package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long totB = in.nextLong();
            long totW = in.nextLong();
            long costB = in.nextLong();
            long costW = in.nextLong();
            long costConversion = in.nextLong();
            long withConversion = Math.min(((totB+totW)*costB)+(totW*costConversion), ((totB+totW) * costW) + (totB*costConversion));
            long withoutConversion = (totB*costB) + (totW*costW);
            System.out.println(Math.min(withConversion, withoutConversion));
        }
    }
}
