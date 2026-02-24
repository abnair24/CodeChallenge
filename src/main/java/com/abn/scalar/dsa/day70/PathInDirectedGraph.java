package com.abn.scalar.dsa.day70;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given an directed graph having A nodes labelled from 1 to A containing
M edges given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 */
public class PathInDirectedGraph {

    List<List<Integer>> adjList = new ArrayList<>();
    public int solve(int vertices, int[][] edges) {

        for(int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            adjList.get(src).add(dest);
        }

        boolean[] visited = new boolean[vertices + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()) {

            int current = queue.poll();
            if(current == vertices) {
                return 1;
            }

            for(int neighbor : adjList.get(current)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        PathInDirectedGraph pathInDirectedGraph = new PathInDirectedGraph();
        System.out.println(pathInDirectedGraph.solve(5, new int[][] {
                {1, 2},
                {4, 1},
                {2, 4},
                {3, 4},
                {5, 2},
                {1, 3}
        }));
    }
}
