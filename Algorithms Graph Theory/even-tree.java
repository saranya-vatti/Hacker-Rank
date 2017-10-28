import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        LinkedList<Integer>[] graph = new LinkedList[n+1];
        LinkedList<Integer>[] tree = new LinkedList[n+1];
        for(int i=0;i<graph.length; i++) {
            graph[i] = new LinkedList<>();
            tree[i] = new LinkedList<>();
        }
        for(int i=0;i<m;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] visited = new int[n+1];
        int[] subtreeNodeCount = new int[n+1];
        for(int i=0;i<subtreeNodeCount.length;i++) {
            subtreeNodeCount[i]=1;
            visited[i]=0;
        }
        // DFS to populate tree
        Stack<Integer> st = new Stack<>();
        st.push(1);
        visited[1] = 1;
        int answer = 0;
        while(!st.isEmpty()) {
            int parent = st.peek();
            int count = 0;
            LinkedList<Integer>[] children = new LinkedList[n+1];
            for(int child:graph[parent]) {
                if(visited[child] == 0) {
                    visited[child]=1;
                    st.push(child);
                    count++;
                    tree[parent].push(child);
                }
            }
            if(count == 0) {
                parent = st.pop();
                for(int child:tree[parent]) {
                    if(subtreeNodeCount[child]%2==0) {
                        answer++;
                    } else {
                        subtreeNodeCount[parent] += subtreeNodeCount[child];
                    }
                }
            }
        }
        System.out.println(answer);
    }
}