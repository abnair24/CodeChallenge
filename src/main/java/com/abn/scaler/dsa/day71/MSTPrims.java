package com.abn.scaler.dsa.day71;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge {

    int vertex;
    int weight;

    public Edge(int source, int weight) {
        this.vertex = source;
        this.weight = weight;
    }
}

public class MSTPrims {

    public int solve(int vertices, int[][] edges) {

        List<List<Edge>> adjList = new ArrayList<>();

        for(int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < vertices; i++) {
            for(int j = i+1; j < vertices; j++) {
                if (edges[i][j] != 0) {
                    adjList.get(i).add(new Edge(j, edges[i][j]));
                    adjList.get(j).add(new Edge(i, edges[i][j]));
                }
            }
        }

        boolean[] isVisitedVertex = new boolean[vertices];
        int totalWeight = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2 )-> Integer.compare(e1.weight, e2.weight));

        int startVertex = 0;
        isVisitedVertex[startVertex] = true;

        for(Edge edge : adjList.get(startVertex)) {
            pq.offer(edge);
        }

        int edgesAdded = 0;

        while(!pq.isEmpty() && edgesAdded < vertices - 1) {
            Edge currentEdge = pq.poll();

            if(isVisitedVertex[currentEdge.vertex]) {
                continue;
            }

            isVisitedVertex[currentEdge.vertex] = true;
            totalWeight += currentEdge.weight;
            edgesAdded++;

            for(Edge edge : adjList.get(currentEdge.vertex)) {
                if(!isVisitedVertex[edge.vertex]) {
                    pq.offer(edge);
                }
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) {

        MSTPrims mstPrims = new MSTPrims();
        int vertices = 4;
        int[][] edges = {
                {0, 1, 3, 4},
                {1, 0, 2, 0},
                {3, 2, 0, 5},
                {4, 0, 5, 0}
        };
        System.out.println(mstPrims.solve(vertices, edges));
    }
}
