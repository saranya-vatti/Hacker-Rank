import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            Stack<String> searchIndexes = new Stack<>();
            char searchFor = P[0].charAt(0);
            for(int i=0;i<=R-r;i++) {
                for(int j=0;j<=C-c;j++) {
                    if(G[i].charAt(j) == searchFor) {
                        searchIndexes.push(i + " " + j);
                    }
                }
            }
            if(searchIndexes.size() == 0) {
                System.out.println("NO");
                continue;
            }
            String ans = "";
            while(!searchIndexes.isEmpty()) {
                String curr = searchIndexes.pop();
                // System.out.println(curr);
                int row = Integer.parseInt(curr.split(" ")[0]);
                int col = Integer.parseInt(curr.split(" ")[1]);
                boolean valid = true;
                for(int i=0;i<r && valid;i++) {
                    for(int j=0;j<c && valid;j++) {
                        if(G[row+i].charAt(col+j) != P[i].charAt(j)) {
                            valid = false;
                        }
                    }
                }
                if(valid) {
                    ans = "YES";
                    break;
                }
            }
            if(ans.equals("")) {
                System.out.println("NO");
            } else {
                System.out.println(ans);
            }
        }
    }
}
