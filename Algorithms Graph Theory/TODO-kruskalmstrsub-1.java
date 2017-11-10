package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
4 5
1 2 1
3 2 150
4 3 99
1 4 100
3 1 200
--200
 */
class Edge implements Comparable<Edge> {
    public int from;
    public int to;
    public int weight;
    Edge(int f, int t, int w) {
        this.from = f;
        this.to = t;
        this.weight = w;
    }

    @Override
    public int compareTo(Edge other) {
        if(this.weight<other.weight) {
            return -1;
        } else if(this.weight>other.weight) {
            return 1;
        }
        int nodeEdgeWeight = this.to + this.from;
        int otherNodeEdgeWeight = other.to + other.from;
        if(nodeEdgeWeight < otherNodeEdgeWeight) {
            return -1;
        } else if(nodeEdgeWeight > otherNodeEdgeWeight) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "[" + this.from + ", " + this.to + "]: " + this.weight;
    }
}
public class Solution {

    private static boolean formsCycle(Set<Edge>[] graph, Edge newEdge) {
        if(graph[newEdge.from] == null || graph[newEdge.to] == null) {
//            System.out.println("2 Doesnt form cycle. Adding");
//            System.out.println("New Edge : " + newEdge.toString());
//            System.out.println();
            return false;
        }
        if(graph[newEdge.from] == graph[newEdge.to]) return true;
        for(int i=1;i<graph.length;i++) {
            if(graph[i] != null) {
//                System.out.print(i + "->");
//                System.out.println(Arrays.toString(graph[i].toArray()));
            }
        }
//        System.out.println("New Edge : " + newEdge.toString());
        graph[newEdge.from].add(newEdge);
        graph[newEdge.to].add(newEdge);
        int[] parents = new int[graph.length+1];
        Stack<Integer> st = new Stack<>();
        st.push(newEdge.from);
        parents[newEdge.from] = newEdge.from;
        while(!st.isEmpty()) {
//            System.out.println(Arrays.toString(parents));
//            System.out.println(Arrays.toString(st.toArray()));
            int parent = st.pop();
//            System.out.println("parent = " + parent);
            int grandparent = parents[parent];
            for(Edge edge:graph[parent]) {
                int child = edge.to == parent ? edge.from : edge.to;
                if(parents[child] != 0 && child != grandparent) {
//                    System.out.println("child = " + child);
//                    System.out.println("parent of parent = " + parents[parent]);
//                    System.out.println("Forms cycle. Not adding");
//                    System.out.println();
                    return true;
                }
                if(parents[child] == 0) {
                    parents[child] = parent;
                    st.push(child);
                }
            }
        }
//        System.out.println("Doesnt form cycle. Adding");
//        System.out.println();
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Edge> edges = new ArrayList<>();
        Set<Edge>[] graph = new HashSet[n+1];
        for(int a1 = 0; a1 < m; a1++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            Edge edge = new Edge(u, v, w);
            if(graph[u] == null) {
                graph[u] = new HashSet<Edge>();
            }
            if(!graph[u].contains(edge)) graph[u].add(edge);
            if(graph[v] == null) {
                graph[v] = new HashSet<Edge>();
            }
            if(!graph[v].contains(edge)) graph[v].add(edge);
            if(!edges.contains(edge)) edges.add(edge);
        }
        edges.sort(Edge::compareTo);
//        System.out.println(Arrays.toString(edges.toArray()));
        Set<Edge>[] reallySpecialSubtree = new HashSet[n+1];
        int overallWeight = 0;
        for(Edge edge:edges) {
            if(!formsCycle(reallySpecialSubtree, edge)) {
                if(reallySpecialSubtree[edge.to] == null) {
                    reallySpecialSubtree[edge.to] = new HashSet<Edge>();
                }
                if(!reallySpecialSubtree[edge.to].contains(edge)) reallySpecialSubtree[edge.to].add(edge);
                if(reallySpecialSubtree[edge.from] == null) {
                    reallySpecialSubtree[edge.from] = new HashSet<Edge>();
                }
                if(!reallySpecialSubtree[edge.from].contains(edge))reallySpecialSubtree[edge.from].add(edge);
                overallWeight+=edge.weight;
            }
        }
        System.out.println(overallWeight);
        in.close();
    }
}
