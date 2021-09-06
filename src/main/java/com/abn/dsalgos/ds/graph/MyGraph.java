package com.abn.dsalgos.ds.graph;

import com.abn.dsalgos.utils.GraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyGraph<T> {

    private Map<GraphNode<T>, List<GraphNode<T>>> vertexMap;
    private HashSet<GraphNode<T>> vertices;

    public MyGraph() {
        vertexMap = new ConcurrentHashMap<>();
        vertices = new HashSet<>();
    }

    public boolean isEmpty() {
        return this.vertices.isEmpty();
    }

    public void addEdge(GraphNode<T> source, GraphNode<T> destination) {

        List<GraphNode<T>> adjVertices = vertexMap.get(source);

        if (adjVertices == null || adjVertices.isEmpty()) {
            adjVertices = new ArrayList<>();
            adjVertices.add(destination);
        } else {
            adjVertices.add(destination);
        }

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

    public HashSet<GraphNode<T>> getVertices() {
        return vertices;
    }

    public void removeVertex(GraphNode<T> vertex) {
        if (!vertices.contains(vertex)) {
            System.out.println("Not found!");
            return;
        }

        vertexMap.forEach((key, value) -> {
            /*
            Removes the vertex if it in the values
             */
            List<GraphNode<T>> vertexAdjList = value;
            vertexAdjList.removeIf(item -> vertex.equals(item));

            /*
            Removes the vertex if its a key
             */
            if (vertex.equals(key)) {
                vertexMap.remove(vertex);
            }

            /*
            Removes from vertex set
             */
            if (vertices.contains(vertex)) {
                vertices.remove(vertex);
            }
        });
    }

    public void printGraph() {
        for (GraphNode<T> vertex : vertexMap.keySet()) {
            List<GraphNode<T>> adjVertex = vertexMap.get(vertex);
            for (GraphNode<T> v : adjVertex) {
                System.out.println(vertex.data + "-->" + v.data);
            }
            System.out.println();
        }
    }


}
