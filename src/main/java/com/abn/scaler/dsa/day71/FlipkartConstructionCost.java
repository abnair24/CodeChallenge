package com.abn.scaler.dsa.day71;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FlipkartConstructionCost {

    private static final int MOD = 1000000007;

    public int solve(int[][] graph, int vertices) {

        if(vertices == 1) {
            return 0;
        }

        if(graph.length == 0 || vertices > 1) {
            return -1;
        }

        List<List<Edge>> adjList = new ArrayList<>();

        for(int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < graph.length; i ++) {

            int src = graph[i][0];
            int dest = graph[i][1];
            int weight = graph[i][2];
            adjList.get(src).add(new Edge(dest, weight));
            // adding to and fro as graph is undirected.
            adjList.get(dest).add(new Edge(src, weight));
        }

        boolean[] isVisitedVertex = new boolean[vertices + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.weight, e2.weight));

        int totalWeight = 0;
        int edgesAdded = 0;

        int startVertex = graph[0][0];
        isVisitedVertex[startVertex] = true;
        for(Edge edge : adjList.get(startVertex)) {
            pq.offer(edge);
        }

        while(!pq.isEmpty() && edgesAdded < vertices - 1) {
            Edge currentEdge = pq.poll();
            if(isVisitedVertex[currentEdge.vertex]) {
                continue;
            }

            isVisitedVertex[currentEdge.vertex] = true;
            totalWeight = (totalWeight + currentEdge.weight) % MOD;
            edgesAdded++;

            for(Edge edge : adjList.get(currentEdge.vertex)) {
                if(!isVisitedVertex[edge.vertex]) {
                    pq.offer(edge);
                }
            }
        }

        return totalWeight;
    }
}
