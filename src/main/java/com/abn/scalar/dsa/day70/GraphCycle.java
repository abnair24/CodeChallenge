package com.abn.scalar.dsa.day70;

import java.util.ArrayList;
import java.util.List;

/*
Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Input 1:

 A = 5
 B = [  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3]
        [3, 4]
        [4, 5] ]

Example Output

Output 1:

 1
Output 2:

 0
 */
public class GraphCycle {
    List<List<Integer>> adjList = new ArrayList<>();

    // States: 0 = unvisited, 1 = in current path, 2 = fully processed
    private static final int UNVISITED = 0;
    private static final int IN_PATH = 1;
    private static final int PROCESSED = 2;

    public int solve(int vertices, int[][] edges) {
        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            adjList.get(src).add(dest);
        }

        int[] state = new int[vertices + 1];
        for(int i = 1; i <= vertices; i++) {
            System.out.println("starting vertex: "+ i);
            if(state[i] == UNVISITED && checkCycle(i, state)) {
                return 1;
            }
        }
        return 0;
    }

    private boolean checkCycle(int vertex, int[] state) {
        System.out.println("vertex: "+ vertex);

        if(state[vertex] == IN_PATH) {
            return true; // Found a cycle
        }

        if(state[vertex] == PROCESSED) {
            return false; // Already processed, no cycle from here
        }

        state[vertex] = IN_PATH;
        List<Integer> neighbors = adjList.get(vertex);

        for(int neighbor : neighbors) {

            if(checkCycle(neighbor, state)) {
                return true;
            }
        }

        state[vertex] = PROCESSED; // Mark as fully processed
        return false;
    }

    public static void main(String[] args) {
        GraphCycle graphCycle = new GraphCycle();
        int[][] edges = {{1,2},{1,3},{2,3},{1,4},{4,3},{4,5},{3,5}};
        System.out.println(graphCycle.solve(5, edges));
    }
}
