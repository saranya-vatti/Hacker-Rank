import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> arraylist = new ArrayList<>();
        for (int i=0;i<n;i++) {
            arraylist.add(in.nextInt());
        }
        Collections.sort(arraylist, Collections.reverseOrder());
        int minIndex = arraylist.size()-1;
        int min;
        while(arraylist.get(0)>0) {
            System.out.println(minIndex+1);
            min = arraylist.get(minIndex);
            for (int currIndex = 0; currIndex < arraylist.size(); currIndex ++) {
                int curr = arraylist.get(currIndex);
                arraylist.set(currIndex, curr-min );
                if(curr-min==0) {
                    minIndex=currIndex-1;
                    break;
                }
            }
        }
    }
}