package com.abn.scaler.dsa.day73;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
Given a weighted undirected graph having A nodes, a source node C and destination node D.

Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.

You are expected to do it in Time Complexity of O(A + M).

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

Input 1:


A = 6
B = [   [2, 5, 1]
        [1, 3, 1]
        [0, 5, 2]
        [0, 2, 2]
        [1, 4, 1]
        [0, 1, 1] ]
C = 3
D = 2
Input 2:

A = 2
B = [   [0, 1, 1]
    ]
C = 0
D = 1


Example Output

Output 1:

 4
Output 2:

 1


Example Explanation

Explanation 1:

The path to be followed will be:
    3 -> 1 (Edge weight : 1)
    1 -> 0 (Edge weight : 1)
    0 -> 2 (Edge weight : 2)
Total length of path = 1 + 1 + 2 = 4.
Explanation 2:

 Path will be 0-> 1.
 */
public class AnotherBFS {

    public int solve(int A, int[][] B, int C, int D) {

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            graph.get(u).add(new int[]{v, weight});
            graph.get(v).add(new int[]{u, weight});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[A];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new int[]{C, 0});
        dist[C] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if (d > dist[node]) {
                continue;
            }

            if (node == D) {
                return dist[D];
            }

            for (int[] edge : graph.get(node)) {
                int neighbor = edge[0];
                int weight = edge[1];
                int newDist = dist[node] + weight;

                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    pq.offer(new int[]{neighbor, newDist});
                }
            }
        }

        return dist[D] == Integer.MAX_VALUE ? -1 : dist[D];
    }
}
