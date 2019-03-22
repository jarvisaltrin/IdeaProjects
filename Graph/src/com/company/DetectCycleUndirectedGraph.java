package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
Like directed graphs, we can use DFS to detect cycle in an undirected graph in O(V+E) time.
We do a DFS traversal of the given graph. For every visited vertex ‘v’, if there is an adjacent ‘u’
such that u is already visited and u is not parent of v, then there is a cycle in graph.

The assumption of this approach is that there are no parallel edges between any two vertices.
 */

public class DetectCycleUndirectedGraph {

    private final int V; // no of vertices
    private final List<List<Integer>> adj;

    public DetectCycleUndirectedGraph(int V){
        this.V = V;
        adj = new ArrayList<List<Integer>>(V);
        for(int i=0;i<V;i++){
            adj.add(new LinkedList<Integer>());
        }
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    public static void main(String args[]) {
         
        DetectCycleUndirectedGraph g1 = new DetectCycleUndirectedGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        DetectCycleUndirectedGraph g2 = new DetectCycleUndirectedGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }

    private boolean isCyclic() {
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            visited[i] = false;
        }
        for(int u=0; u<V; u++){
            if(!visited[u]){
                if(isCyclicUtil(u, visited, -1))
                    return true;
            }
        }
        return false;
    }

    // A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex v.
    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj.get(v).iterator();
        while(it.hasNext()){
            i = it.next();
            // if an adjacent is not visited, then recur for that adjacent
            if(!visited[i]){
                if(isCyclicUtil(i, visited, v))
                    return true;
            }
            // if an adjacent is visited and not parent of current vertex, then there is a cycle
            else if(i != parent)
                return true;
        }
        return false;
    }
}
