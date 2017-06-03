//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // Declare a String to String map
        Map<String, Integer> myMap; 

        // Initialize it as a new String to String HashMap
        myMap = new HashMap<String, Integer>();  

        // Change myMap to be a new (completely different) String to String LinkedHashMap instead
        myMap = new LinkedHashMap<String, Integer>(); 
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            myMap.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            if(myMap.containsKey(s)) {
                System.out.println(s + "=" + myMap.get(s));
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}
