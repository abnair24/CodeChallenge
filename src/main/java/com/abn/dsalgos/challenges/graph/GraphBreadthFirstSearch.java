package com.abn.dsalgos.challenges.graph;

import com.abn.dsalgos.utils.GraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class GraphBreadthFirstSearch<T> {

    private Map<GraphNode<T>, List<GraphNode<T>>> vertexMap;
    private HashSet<GraphNode<T>> vertices;

    public GraphBreadthFirstSearch() {
        vertexMap = new ConcurrentHashMap<>();
        vertices = new HashSet<>();
    }

    public void addEdge(GraphNode<T> source, GraphNode<T> destination) {

        List<GraphNode<T>> adjVertices = vertexMap.get(source);

        if (adjVertices == null || adjVertices.isEmpty()) {
            adjVertices = new ArrayList<>();
        }
        adjVertices.add(destination);

        vertexMap.put(source, adjVertices);
        vertices.add(source);
        vertices.add(destination);
    }

    public void removeEdge(GraphNode<T> src, GraphNode<T> dest) {

        if (vertexMap.get(src) != null) {
            vertexMap.remove(dest);
        }

        if (vertexMap.get(dest) != null) {
            vertexMap.remove(src);
        }
    }

    public void BFS(GraphNode<T> startNode) {

        Queue<GraphNode<T>> queue = new LinkedList<>();
        queue.add(startNode);
        startNode.visited = true;

        while (!queue.isEmpty()) {

            GraphNode<T> temp = queue.poll();
            System.out.println(temp.data);

            List<GraphNode<T>> adjVertexList = vertexMap.get(temp);
            for (GraphNode<T> v : adjVertexList) {
                if (!v.visited) {
                    v.visited = true;
                    queue.add(v);
                }
            }
        }
    }

}
