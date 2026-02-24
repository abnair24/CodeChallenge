package com.abn.scalar.dsa.day70;

import java.util.ArrayList;
import java.util.List;

public class ScalerGraph {

    private List<List<Integer>> adjList;
    private int vertices;

    public ScalerGraph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for(int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    public ScalerGraph (int vertices, int[][] edges) {
        this.vertices  = vertices;
        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }

    public ScalerGraph(int vertices, int[][] edges, boolean isDirected) {
        this.vertices  = vertices;
        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adjList.get(src).add(dest);
            if(!isDirected) {
                adjList.get(dest).add(src);
            }
        }
    }

    public List<Integer> getNeighbors(int vertex) {
        if(vertex < 0 || vertex >= vertices) {
            throw new IllegalArgumentException("Vertex out of bounds");
        }
        return adjList.get(vertex);
    }
}
