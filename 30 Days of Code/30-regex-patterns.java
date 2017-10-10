import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        String[] names = new String[t];
        int j=0;
        for (int i=0;i<t;i++) {
            String myString = sc.nextLine();
            String myRegExString = "([^\\s]*)\\s.*@gmail.com$";
            // Create a Pattern object (compiled RegEx) and save it as 'p'
            Pattern p = Pattern.compile(myRegExString);

            // We need a Matcher to match our compiled RegEx to a String
            Matcher m = p.matcher(myString);

            // if our Matcher finds a match
            if( m.find()) {
                // Print the match
                names[j++] = m.group(1);
            }
        }
        String[] namessorted = new String[j];
        for (int i=0;i<j;i++) {
            namessorted[i] = names[i];
        }
        Arrays.sort(namessorted);
        for (int i=0;i<j;i++) {
            System.out.println(namessorted[i]);
        }
    }
}