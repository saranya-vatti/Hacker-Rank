import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while(q-->0) {
            int n = in.nextInt();
            LinkedList<Integer>[] graph = new LinkedList[n+1];
            for(int i=0;i<graph.length; i++) {
                graph[i] = new LinkedList<>();
            }
            int[] visited = new int[n+1];
            int m = in.nextInt();
            long clib = in.nextInt();
            long croad = in.nextInt();
            long ccCounter = 1;
            long cost = 0;
            for(int i=0;i<m;i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }
            for(int i=1;i<=n;i++) {
                if(visited[i]==0) {
                    Stack<Integer> st = new Stack();
                    visited[i]=1;
                    st.push(i);
                    int num_roads = 0;
                    while(!st.isEmpty()) {
                        int parent = st.pop();
                        for (int child : graph[parent]) {
                            if (visited[child]==0) {
                                num_roads++;
                                visited[child]=1;
                                st.push(child);
                            }
                        }
                    }
                    cost += Math.min((num_roads*croad)+clib, (num_roads+1)*clib);
                    ccCounter++;
                }
            }
            System.out.println(cost);
        }
    }
}
