package com.abn.scalar.dsa.day71;

import java.util.LinkedList;
import java.util.Queue;

/*
There are N no of nodes and multi source s1, s2, s3. we need to find shortest path for given
destination node  to any one of source node
 */
public class ShortestPathMultisourceToDestination {

    public int solve(int[][] graph, int[] sources, int destination) {
        int nodes = graph.length;

        for(int source : sources) {
            if (source == destination) {
                return 0;
            }
        }

        boolean[] isVisited = new boolean[nodes];
        Queue<Integer> queue = new LinkedList<>();

        for(int source : sources) {
            queue.offer(source);
            isVisited[source] = true;
        }

        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;

            for(int i = 0; i < size; i ++) {
                int currentNode = queue.poll();

                for(int neighbour = 0; neighbour < nodes; neighbour ++) {
                    // in graph, row number always shows the node
                    if(graph[currentNode][neighbour] == 1 && !isVisited[neighbour]) {

                        if(neighbour == destination) {
                            return distance;
                        }

                        isVisited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathMultisourceToDestination shortestPathMultisourceToDestination = new ShortestPathMultisourceToDestination();
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };
        int[] sources = {0, 2};
        int destination = 3;
        System.out.println(shortestPathMultisourceToDestination.solve(graph, sources, destination));
    }
}
