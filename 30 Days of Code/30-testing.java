import java.io.*;
import java.util.*;
class Solution
{
    static int minN = 3;
    static int maxN = 20;
    static int maxA = 30;
    static int minA = -30;
    static Random ran = new Random();
    static int testCases = 5;
    static int[] nArr = new int[testCases];
    private static int getRandom(int aStart, int aEnd){
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        //get the range, casting to long to avoid overflow problems
        long range = (long)aEnd - (long)aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long)(range * ran.nextDouble());
        int randomNumber =  (int)(fraction + aStart);
        return randomNumber;
    }
    private static boolean isUniqueN(int n) {
        for (int i=0;i<testCases;i++) {
            if(nArr[i] == n) return false;
        }
        return true;
    }
    private static int generateUniqueN () {
        int num = getRandom(minN, maxN);
        while (!isUniqueN(num)) {
            num = getRandom(minN, maxN);
        }
        return num;
    }
    private static void generateSuccessTestCase(int num, int k) {
        int minNum = k>2? k : 2;
        int posA = getRandom(minNum, num);
        System.out.print("0 ");
        for (int i=1;i<posA;i++) {
            System.out.print(getRandom(0, maxA) + " ");
        }
        for (int i=posA;i<num;i++) {
            System.out.print(getRandom(minA, -1) + " ");
        }
        System.out.println();
    }
    private static void generateFailureTestCase(int num, int k) {
        int posA = getRandom(2, k-1);
        System.out.print("0 ");
        for (int i=1;i<posA;i++) {
            System.out.print(getRandom(0, maxA) + " ");
        }
        for (int i=posA;i<num;i++) {
            System.out.print(getRandom(minA, -1) + " ");
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        int k;
        System.out.println("5");
//        System.out.println("4 3");
//        System.out.println("-1 -3 4 2");
//        System.out.println("5 2");
//        System.out.println("0 -1 2 1 4");
        nArr[0] = generateUniqueN();
        k = getRandom(3, nArr[0]);
        System.out.println(nArr[0] + " " + k);
        generateFailureTestCase(nArr[0], k);

        nArr[1] = generateUniqueN();
        k = getRandom(3, nArr[1]);
        System.out.println(nArr[1] + " " + k);
        generateSuccessTestCase(nArr[1], k);

        nArr[2] = generateUniqueN();
        k = getRandom(3, nArr[2]);
        System.out.println(nArr[2] + " " + k);
        generateFailureTestCase(nArr[2], k);

        nArr[3] = generateUniqueN();
        k = getRandom(3, nArr[3]);
        System.out.println(nArr[3] + " " + k);
        generateSuccessTestCase(nArr[3], k);

        nArr[4] = generateUniqueN();
        k = getRandom(3, nArr[4]);
        System.out.println(nArr[4] + " " + k);
        generateFailureTestCase(nArr[4], k);
    }
}