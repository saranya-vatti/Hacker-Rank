import java.io.*;
import java.util.*;

public class Solution {

    private static boolean helper(String s) {
        // System.out.println(s);
        if(s.length() == 0) return true;
        if(s.length() %2 != 0) return false;
        int lastRound = s.lastIndexOf('(');
        int lastCurly = s.lastIndexOf('{');
        int lastSquare = s.lastIndexOf('[');
        if(lastRound > lastCurly && lastRound > lastSquare) {
            int next = lastRound + 1 + s.substring(lastRound, s.length()).indexOf(')');
            if(next == -1) return false;
            s = s.substring(0, lastRound) + s.substring(next, s.length());
        }
        if(lastCurly > lastRound && lastCurly > lastSquare) {
            int next = lastCurly + 1 + s.substring(lastCurly, s.length()).indexOf('}');
            if(next == -1) return false;
            s = s.substring(0, lastCurly) + s.substring(next, s.length());
        }
        if(lastSquare > lastCurly && lastSquare > lastRound) {
            int next = lastSquare + 1 + s.substring(lastSquare, s.length()).indexOf(']');
            if(next == -1) return false;
            s = s.substring(0, lastSquare) + s.substring(next, s.length());
        }
        return helper(s);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(helper(s) ? "True" : "False");
    }
}