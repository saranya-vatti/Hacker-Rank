package com.company;
import java.util.*;
class Edge {
    private int from;
    private int to;
    private int weight;
    public int getFrom() {
        return this.from;
    }
    public int getTo() {
        return this.to;
    }
    public int getWeight() {
        return this.weight;
    }
    Edge(int from, int to, int wt) {
        this.weight = wt;
        this.to = to;
        this.from = from;
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, boolean[]> nodeMap= new HashMap<>();
        int m = in.nextInt();
        int[][] graph = new int[n+1][n+1];
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<n+1;j++) {
                graph[i][j] = -1;
            }
        }
        int k = in.nextInt();
        for(int i=1;i<=n;i++) {
            int t = in.nextInt();
            boolean[] tmp = new boolean[k];
            for(int j=0;j<k;j++) {
                tmp[j]=false;
            }
            for(int j=0;j<t;j++) {
                tmp[in.nextInt()-1] = true;
            }
            nodeMap.put(i, tmp);
        }
        for(int j=0;j<m;j++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            graph[x][y] = z;
        }
        int curr = 1;
        int minWeight = Integer.MAX_VALUE;
        while(curr<=n) {
            int weight=0;
            int typesEncountered = 0;
            boolean[] kUpdated = new boolean[k];
            for(int j=0;j<k;j++) {
                kUpdated[j] = false;
            }
            for(int i=1; i<=n;i++) { // convert this to while loop, do bfs
                if(graph[curr][i] > -1) {
                    weight += graph[curr][i]; //check if typesEncountered increases before doing this
                    for(int j=0;j<nodeMap.get(i).length;j++) {
                        kUpdated[j] = kUpdated[j] && nodeMap.get(i)[j];
                    }
                    graph[curr][i] = -1;
                }
            }
            if(weight<minWeight) minWeight = weight;
            curr++;
        }
    }
}