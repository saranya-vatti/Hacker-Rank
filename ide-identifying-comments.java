import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int nested = 0;
        StringBuilder sb = new StringBuilder();
        String line;
        while(sc.hasNextLine()) {
            line = sc.nextLine().trim();
            int startMulti = line.indexOf("/*");
            int endMulti = line.indexOf("*/");
            int singleLine = line.indexOf("//");
            if(nested > 0) {
                if(singleLine != -1 && startMulti != -1 && endMulti != -1) {
                    if(endMulti < singleLine && singleLine < startMulti){
                        sb.append(line.substring(0, endMulti+2));
                        sb.append(line.substring(singleLine));
                        sb.append("\n");
                    } else if (endMulti < startMulti && startMulti < singleLine) {
                        sb.append(line.substring(0, endMulti+2));
                        sb.append(line.substring(startMulti));
                        sb.append("\n");
                    } else if(startMulti < endMulti && endMulti < singleLine) {
                        sb.append(line.substring(0, endMulti+2));
                        sb.append(line.substring(singleLine));
                        sb.append("\n");
                    } else if(singleLine < endMulti && endMulti < startMulti) {
                        sb.append(line.substring(0, endMulti+2));
                        sb.append(line.substring(startMulti));
                        sb.append("\n");
                    } else {
                        sb.append(line.substring(0, endMulti+2));
                        sb.append("\n");
                    }
                    nested--;
                } else if(startMulti != -1 && endMulti != -1) {
                    if(startMulti < endMulti) {
                        sb.append(line.substring(0, endMulti+2));
                        sb.append("\n");
                        nested--;
                    } else {
                        sb.append(line.substring(0, endMulti+2));
                        sb.append(startMulti);
                        sb.append("\n");
                    }
                } else if(singleLine != -1 && endMulti != -1) {
                    if(singleLine < endMulti) {
                        sb.append(line.substring(0, endMulti+2));
                        sb.append("\n");
                    } else {
                        sb.append(line.substring(0, endMulti+2));
                        sb.append(singleLine);
                        sb.append("\n");
                    }
                    nested--;
                } else if(endMulti != -1) {
                    sb.append(line.substring(0, endMulti+2));
                    sb.append("\n");
                    nested--;
                } else {
                    sb.append(line);
                    sb.append("\n");
                }
            } else {
                if(singleLine != -1 && startMulti != -1 && endMulti != -1) {
                    if(startMulti < endMulti && endMulti < singleLine){
                        sb.append(line.substring(startMulti, endMulti+2));
                        sb.append(line.substring(singleLine));
                        sb.append("\n");
                    } else if(startMulti < singleLine && singleLine < endMulti) {
                        sb.append(line.substring(startMulti, endMulti+2));
                        sb.append("\n");
                    } else {
                        sb.append(line.substring(singleLine));
                        sb.append("\n");
                    }
                } else if(singleLine != -1 && startMulti != -1) {
                    if(singleLine < startMulti) {
                        sb.append(line.substring(singleLine));
                        sb.append("\n");
                    } else {
                        sb.append(line.substring(startMulti));
                        sb.append("\n");
                        nested++;
                    }
                } else if(startMulti != -1 && endMulti != -1) {
                    sb.append(line.substring(startMulti, endMulti+2));
                    sb.append("\n");
                } else if(singleLine != -1) {
                    sb.append(line.substring(singleLine));
                    sb.append("\n");
                } else if (startMulti != -1) {
                    sb.append(line.substring(startMulti));
                    sb.append("\n");
                    nested++;
                }
            }
        }
        sc.close();
        System.out.println(sb);
    }
}
