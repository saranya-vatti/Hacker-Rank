import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] s = new String[n];
        for(int i=0;i<n;i++) {
            s[i] = in.nextLine();
        }
        int keyToOrder = Integer.parseInt(in.next());
        boolean isReverse = Boolean.parseBoolean(in.next());
        boolean isNumeric = in.next() == "numeric";
        if(isNumeric) {
            HashMap<Integer, String> map = new HashMap<>();
            for(int i=0;i<n;i++) {
                map.put(Integer.parseInt(s[i].split(" ")[keyToOrder-1]), s[i]);
            }
            SortedSet<Integer> keys = new TreeSet<Integer>(map.keySet());
            if(isReverse) keys = new TreeSet<Integer>(map.keySet()).descendingSet();
            for (int key : keys) { 
               System.out.println(map.get(key));
            }
        } else {
            HashMap<String, String> map = new HashMap<>();
            for(int i=0;i<n;i++) {
                map.put(s[i].split(" ")[keyToOrder-1], s[i]);
            }
            SortedSet<String> keys = new TreeSet<String>(map.keySet());
            if(isReverse) keys = new TreeSet<String>(map.keySet()).descendingSet();
            for (String key : keys) { 
               System.out.println(map.get(key));
            }
        }
    }
}