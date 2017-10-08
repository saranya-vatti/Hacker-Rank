package com.company;
import java.util.*;
import java.io.*;
// zzzayybbaa -> zzzbaaabyy
// a -> no answer
// Passes all test cases afaik. Maybe some problem with 10000 input and output. Use BufferedReader and OutputStreamWriter?
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            char[] arr = s.toCharArray();
            int substrstart=arr.length-1;
            for(int i=arr.length-2;i>=0;i--) {
                if(arr[i]<arr[i+1]) {
                    substrstart = i;
                    break;
                }
            }
            if(substrstart>=arr.length-1) {
                System.out.println("no answer");
            } else {
                char curr = arr[substrstart];
                Arrays.sort(arr, substrstart, arr.length);
                for(int i=substrstart;i<arr.length-1;i++) {
                    if(curr==arr[i]) {
                        for(int j=i+1;j<arr.length;j++) {
                            if(arr[j]>curr) {
                                char tmp = arr[substrstart];
                                arr[substrstart] = arr[j];
                                arr[j] = tmp;
                                break;
                            }
                        }
                    }
                }
                Arrays.sort(arr, substrstart+1, arr.length);
                String answer = new String(arr);
                if(answer.equals(s)) {
                    System.out.println("no answer");
                } else {
                    System.out.println(answer);
                }
            }
        }
    }
}
