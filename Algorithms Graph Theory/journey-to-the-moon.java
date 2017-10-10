import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        LinkedList<Integer>[] graph = new LinkedList[n];
        for(int i=0;i<graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        int[] visited = new int[n];
        long nodeSum = 0;
        long p = in.nextInt();
        long num_of_ways = 0;
        for(long i=0;i<p;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=0;i<n;i++) {
            if(visited[i]==0) {
                Stack<Integer> st = new Stack();
                visited[i]=1;
                st.push(i);
                long num_nodes = 1;
                while(!st.isEmpty()) {
                    int parent = st.pop();
                    for (int child : graph[parent]) {
                        if (visited[child]==0) {
                            num_nodes++;
                            visited[child]=1;
                            st.push(child);
                        }
                    }
                }
                num_of_ways = num_of_ways + (nodeSum*num_nodes);
                nodeSum+=num_nodes;
            }
        }
        System.out.println(num_of_ways);
    }
}