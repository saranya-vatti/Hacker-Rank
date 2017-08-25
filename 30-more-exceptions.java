import java.util.*;
import java.io.*;
class Calculator {
    public int power(int m, int n) throws Exception {
        if (m<0 || n<0) {
            throw new Exception("n and p should be non-negative");
        }
        int ans = 1;
        for(int i=1;i<=n;i++) {
            ans = ans*m;
        }
        return ans;
    }
}
class Solution{

    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
        
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}
