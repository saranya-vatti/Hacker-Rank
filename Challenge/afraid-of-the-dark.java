import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] s = new int[n+1];
            s[0] = -1;
            for(int s_i = 1; s_i <= n; s_i++){
                s[s_i] = in.nextInt();
            }
            LinkedList<Integer>[] graph = new LinkedList[n+1];
            for(int i=0;i<graph.length; i++) {
                graph[i] = new LinkedList<Integer>();
            }
            for(int a1 = 0; a1 < n-1; a1++){
                int a = in.nextInt();
                int b = in.nextInt();
                graph[a].add(b);
                graph[b].add(a);
            }
            for(int i=1;i<=n;i++) {
                int numSwitchedOn = 0;
                int[] visited = new int[n+1];
                int[] subtreeNodeCount = new int[n+1];
                LinkedList<Integer>[] tree = new LinkedList[n+1];
                for(int j=0;j<graph.length; j++) {
                    tree[j] = new LinkedList<Integer>();
                }
                for(int j=0;j<subtreeNodeCount.length;j++) {
                    subtreeNodeCount[j]=1;
                    visited[j]=0;
                }
                Stack<Integer> st = new Stack<>();
                st.push(i);
                int answer = 0;
                visited[i] = 1;
                if(s[i]==0) {
                    numSwitchedOn++;
                }
                answer++;
                int min = Integer.MAX_VALUE;
                while(!st.isEmpty()) {
                    int count=0;
                    int parent = st.peek();
                    for(int child:graph[parent]) {
                        if(visited[child] == 0) {
                            visited[child]=1;
                            if(s[child]==0) {
                                numSwitchedOn++;
                            }
                            st.push(child);
                            count++;
                            answer++;
                            tree[parent].push(child);
                        }
                    }
                    if(count == 0) {
                        parent = st.pop();
                        for(int child:tree[parent]) {
                            subtreeNodeCount[parent] += subtreeNodeCount[child];
                        }
                        if(s[parent] == 0 && min>subtreeNodeCount[parent]) {
                            min = subtreeNodeCount[parent];
                        }
                    }
                }
                if(numSwitchedOn%2==1) {
                    answer -= min;
                }
                System.out.println(answer);
            }
        }
        in.close();
    }
}
