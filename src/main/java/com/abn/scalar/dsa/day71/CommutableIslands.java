package com.abn.scalar.dsa.day71;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CommutableIslands {

    public int solve(int A, int[][] B) {

        List<List<Edge>> adjList = new ArrayList<>();

        for(int i = 0; i <= A; i ++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < B.length; i++) {

            adjList.get(B[i][0]).add(new Edge(B[i][1], B[i][2]));
            adjList.get(B[i][1]).add(new Edge(B[i][0], B[i][2]));

        }


        boolean[] isVisitedVertex = new boolean[A + 1];
        int totalWeight = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2)-> Integer.compare(e1.weight, e2.weight));
        int startVertex = B[0][0];

        isVisitedVertex[startVertex] = true;

        for(Edge edge : adjList.get(startVertex)) {
            pq.offer(edge);
        }

        int edgesAdded = 0;

        while(!pq.isEmpty()) {

            Edge current= pq.poll();

            if(isVisitedVertex[current.vertex]) {
                continue;
            }

            isVisitedVertex[current.vertex] = true;
            totalWeight = totalWeight + current.weight;
            edgesAdded++;
            for(Edge edge : adjList.get(current.vertex)) {
                if(!isVisitedVertex[edge.vertex]) {
                    pq.offer(edge);
                }
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) {

        CommutableIslands commutableIslands = new CommutableIslands();
        int[][] edges = {
                {1, 2, 10},
                {2, 3, 5},
                {1, 3, 9}
        };
        System.out.println(commutableIslands.solve(3, edges));
    }
}
