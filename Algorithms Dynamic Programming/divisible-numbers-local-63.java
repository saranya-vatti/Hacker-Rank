/* Score: 63.27
 55, 99, 135, 165, 185, 198, 225, 235, 245, 275, 297, 315, 325, 342, 365, 385, 395, 396, 405, 425, 455, 475, 485, 495, 505, 525
 24261 the answer was expected to be 15 - 111151121111112
 32 the expected answer is 4 and for 54 expected answer is 5

1 digit: "1", "2", "3", "4", "5", "6", "7", "8", "9"
2 digit: "11", "12", "13", "14", "15", "16", "17", "18", "19", "22"
3 digiti:"111", "119", "118", "117", "116", "115", "114", "113", "112", "123", "122"
4 digit: "1111", "1112", "1113", "1114", "1115", "1116", "1117", "1118", "1119", "1121", "1122", "1123", "1124"
5 digit: "11111", "11112", "11113", "11114", "11115", "11118", "11119", "11116", "11117", "11123", "11122", "11125", "11124", "11133", "11222"
6 digit: "111133", "111126", "111125", "111124", "111123", "111122", "111118", "111119", "111116", "111117", "111114", "111115", "111112", "111113", "111111", "111222"
7 digit: "1111123", "1111122", "1111125", "1111124", "1111127", "1111126", "1111222", "1111133", "1111134", "1111111", "1111112", "1111113", "1111114", "1111115", "1111116", "1111117", "1111118", "1111119"
8 digit: "11111126", "11111127", "11111124", "11111125", "11111122", "11111123", "11111134", "11111133", "11111128", "11111111", "11111119", "11111118", "11111117", "11111116", "11111223", "11111115", "11111222", "11111114", "11111113", "11111112"
*/

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.math.*;

public class Main {

    static Boolean isValidNum = false;
    static BigInteger num;
    static BigInteger basePermutation;
    static Boolean solutionAchieved = false;
    static HashSet<String> sortedPerms=new HashSet<String>();
    static int totalNumbersChecked = 0;

    static String getMin(int dig) {
        String str = "";
        for(int i =0;i<dig;i++) {
            str += '1';
        }
        return str;
    }

    static Boolean checkSumProd(String str) {
        totalNumbersChecked++;
        int sum = 0;
        int prod = 1;
        for(int i =0; i<str.length();i++) {
            int dig = str.charAt(i) - '0';
            sum += dig;
            prod *= dig;
        }
        return sum>=prod;
    }

    static String getNextBasePermutation(String num) {

        HashSet<String> checked=new HashSet<String>();
        int numlen = num.length();
        char[] digits=num.toCharArray();
        System.out.println("Finding next base of : " + num);
        Boolean incNextDigFlag = false;
        while(true) {
            int tmpindex = numlen - 1;
            if (digits[numlen - 1] >= '9') {
                while (digits[tmpindex] >= '9') {
                    if(tmpindex == 0) return "";
                    tmpindex--;
                }
                digits[tmpindex]++;
                for(int i=tmpindex;i<numlen;i++) {
                    digits[i] = digits[tmpindex];
                }
                System.out.println("Found 9 and incremented accordingly: " + String.valueOf(digits));
            } else if (incNextDigFlag) {
                int curr = numlen-1;
                while(curr != '1') {
                    curr--;
                }
                for(int i=curr;i<numlen;i++) {
                    digits[i] = '2';
                }
                System.out.println("Incrementing digits: " + String.valueOf(digits));
            } else {
                digits[numlen - 1]++;
                System.out.println("Did not find 9 and incremented accordingly: " + String.valueOf(digits));
            }
            num = String.valueOf(digits);
            if (checkSumProd(num)) {
                System.out.println("Valid and returning : " + num);
                return num;
            } else {
                System.out.println("Invalid and incrementing");
                int curr = numlen - 2;
                int prev = numlen - 1;
                while (num.charAt(curr) == num.charAt(prev)) {
                    if (curr == 0) return "";
                    prev = curr;
                    curr--;
                }
                digits[curr]++;
                Boolean flag = digits[curr] == '2';
                for (int i = curr + 1; i < numlen; i++) {
                    digits[i] = digits[curr];
                }
                num = String.valueOf(digits);
                System.out.println("Incremented to : " + num);
                if (checkSumProd(num)) {
                    return num;
                } else if (flag) {
                    return "";
                } else {
                    incNextDigFlag = true;
                }
            }
        }
    }

    static String partialSort(String str, int start) {
        int total = str.length();
        if(start>=total-1) return str;
        char[] c=str.toCharArray();
        char[] result = new char[total];
        char a[]=new char[total-start];
        int j=0;
        for(int i=start;i<total;i++) {
            a[j++] = c[i];
        }
        Arrays.sort(a);
        for(int i=0;i<start;i++) {
            result[i] = c[i];
        }
        for(int i=start;i<total;i++) {
            result[i] = a[i-start];
        }
        return String.valueOf(result);
    }

    static String swap(String str, int index1, int index2) {
        if(index1>index2) {
            int tmp = index1;
            index1 = index2;
            index2 = tmp;
        }
        char[] c=str.toCharArray();
        int total = c.length;
        char[] result = new char[total];
        for(int i=0;i<total;i++) {
            if (i==index1) result[i] = c[index2];
            else if (i==index2) result[i] = c[index1];
            else result[i] = c[i];
        }
        return String.valueOf(result);
    }

    /* which is greater than 'first' and is present in str[l..h]*/
    static int findCeil(String str, char first, int l, int h)
    {
        /* initialize index of ceiling element */
        int ceilIndex = l;

        /* Now iterate through rest of the elements and find
        the smallest character greater than 'first' */
        for (int i = l+1; i <= h; i++)
            if (str.charAt(i) > first && str.charAt(i) < str.charAt(ceilIndex))
                ceilIndex = i;

        return ceilIndex;
    }

    /* Aff all permutations of str in sorted order*/
    static void sortedPermutations(String str)
    {
        int size = str.length();

        /* Sort the string in increasing order */
        char [] c = str.toCharArray(); Arrays.sort(c); str = String.valueOf(c);

        /* Print permutations one by one */
        Boolean isFinished = false;
        while (!isFinished)
        {
            /* add this permutation */
            sortedPerms.add(str);

            /* Find the rightmost character which is smaller than its next
            character. Let us call it 'first char' */
            int i;
            for (i = size - 2; i >= 0; --i)
                if (str.charAt(i) < str.charAt(i+1))
                    break;

            /* If there is no such character, all are sorted in decreasing order,
                means we just added the last permutation and we are done. */
            if (i == -1)
                isFinished = true;
            else
            {
                /* Find the ceil of 'first char' in right of first character.
                    Ceil of a character is the smallest character greater than it */
                int ceilIndex = findCeil(str, str.charAt(i), i + 1, size - 1);

                /* Swap first and second characters */
                    str = swap(str, i, ceilIndex);

                /* Sort the string on right of 'first char' */
                str = partialSort(str, i + 1);
            }
        }
    }

    static void checkDigits(int dig) {
        String min = getMin(dig);
        String nextBase = min.toString();
        while (!nextBase.equals("")) {
            System.out.println("nextBase : " + nextBase);
            sortedPerms = new HashSet<String>();
            sortedPermutations(nextBase.toString());
            System.out.println("Number of Permutations : " + sortedPerms.size());
            for (String nextMinStr : sortedPerms) {
                BigInteger nextMin = new BigInteger(nextMinStr);
                if(nextMin.mod(num).equals(BigInteger.valueOf(0))) {
                    solutionAchieved = true;
                    System.out.println(dig);
                    System.out.println("totalNumbersChecked : " + totalNumbersChecked);
                    return;
                }
            }
            nextBase = getNextBasePermutation(nextBase.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        num = scan.nextBigInteger();
        int i = num.toString().length();
        while(!solutionAchieved) {
            checkDigits(i);
            i++;
        }
    }
}