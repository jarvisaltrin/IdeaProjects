package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
For a disconnected graph, we get the DFS forest as output. To detect cycle,
we can check for a cycle in individual trees by checking back edges.

To detect a back edge, we can keep track of vertices currently in recursion stack of function for DFS traversal.
If we reach a vertex that is already in the recursion stack, then there is a cycle in the tree.
The edge that connects current vertex to the vertex in the recursion stack is a back edge.
 */

public class DetectCycleDirectedGraph {

    private final int V; // no of vertices
    private final List<List<Integer>> adj;

    public DetectCycleDirectedGraph(int V){
        this.V = V;
        adj = new ArrayList<List<Integer>>(V);
        for(int i=0;i<V;i++){
            adj.add(new LinkedList<Integer>());
        }
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }


    private boolean isCyclic(){
        // mark all the vertices as not visited and not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i=0;i<V;i++){
            if(isCyclicUtil(i, visited, recStack))
                return true;
        }
        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        if(recStack[i])
            return true;
        if(visited[i])
            return false;
        visited[i] = true;
        recStack[i] = true;
        List<Integer> child = adj.get(i);
        for(Integer c : child){
            if (isCyclicUtil(c,visited,recStack))
                return true;
        }
        recStack[i] = false;
        return false;
    }

    // A variation of DFS to find cycle in a graph
    public static void main(String[] args){
        DetectCycleDirectedGraph graph = new DetectCycleDirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");

    }
}
