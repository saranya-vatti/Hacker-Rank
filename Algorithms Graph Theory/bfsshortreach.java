package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            boolean[] isNode = new boolean[1001];
            int m = in.nextInt();
            Set<Integer>[] graph = new HashSet[1001];
            for(int a1 = 0; a1 < m; a1++){
                int u = in.nextInt();
                int v = in.nextInt();
                if(graph[u] == null) {
                    graph[u] = new HashSet<Integer>();
                }
                graph[u].add(v);
                if(graph[v] == null) {
                    graph[v] = new HashSet<Integer>();
                }
                graph[v].add(u);
                isNode[u]=true;
                isNode[v] = true;
            }
            int s = in.nextInt();
            int[] distance = new int[1001];
            for(int i=0;i<=1000;i++) {
                distance[i] = -1;
            }
            Queue<Integer> qu = new LinkedList<>();
            qu.add(s);
            int dist = 0;
            distance[s] = 0;
            while(!qu.isEmpty()) {
                int parent = qu.remove();
                dist = distance[parent]+6;
                if(graph[parent] != null) {
                    for(int adj:graph[parent]) {
                        if(distance[adj]==-1) {
                            distance[adj] = dist;
                            qu.add(adj);
                        } else {
                            distance[adj] = Math.min(distance[adj], dist);
                        }
                    }
                }
            }
            StringBuilder str = new StringBuilder("");
            for(int i=1;i<=n;i++) {
                if (i!=s) {
                    str.append(distance[i]);
                    str.append(" ");
                }
            }
            System.out.println(str);
        }
        in.close();
    }
}
