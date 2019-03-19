package com.abn.dsalgos.ds.graph;

import com.abn.dsalgos.utils.GraphNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MyGraph<T> {

    private Map<GraphNode<T>, List<GraphNode<T>>> vertexMap;
    private HashSet<T> vertices;

    public MyGraph() {
        vertexMap = new ConcurrentHashMap<>();
        vertices = new HashSet<>();
    }

    public boolean isEmpty() {
        return this.vertices.isEmpty();
    }

    public void addEdge(T sourceNode, T destinationNode) {

        GraphNode<T> destNode = new GraphNode<>(destinationNode);
        GraphNode<T> srcNode = new GraphNode<>(sourceNode);

        List<GraphNode<T>> adjVertices = vertexMap.get(srcNode);

        if (adjVertices == null || adjVertices.isEmpty()) {
            adjVertices = new ArrayList<>();
            adjVertices.add(destNode);
        } else {
            adjVertices.add(destNode);
        }

        vertexMap.put(srcNode, adjVertices);

        vertices.add(destinationNode);
        vertices.add(sourceNode);
    }

    public HashSet<T> getVertices() {
        return vertices;
    }

    public void removeEdge(T src, T dest) {

        GraphNode<T> source = new GraphNode<>(src);
        GraphNode<T> destination = new GraphNode<>(dest);

        if (vertexMap.get(source) != null) {
            vertexMap.remove(destination);
        }

        if (vertexMap.get(destination) != null) {
            vertexMap.remove(source);
        }
    }

    public void removeVertex(T vertex) {
        if (!vertices.contains(vertex)) {
            System.out.println("Not found!");
            return;
        }

        GraphNode<T> vertexNode = new GraphNode<>(vertex);

        for (Map.Entry<GraphNode<T>, List<GraphNode<T>>> entry : vertexMap.entrySet()) {

            /*
            Removes the vertex if it in the values
             */
            List<GraphNode<T>> vertexAdjList = entry.getValue();
            if (vertexAdjList.contains(vertexNode)) {
                vertexAdjList.remove(vertexNode);
            }
            /*
            Removes the vertex if its a key
             */
            if (vertexNode.equals(entry.getKey())) {
                vertexMap.remove(vertexNode);
            }

            /*
            Removes from vertex set
             */
            if (vertices.contains(vertex)) {
                vertices.remove(vertex);
            }
        }
    }


    public void printGraph() {
        for(GraphNode<T> vertex : vertexMap.keySet()) {
            List<GraphNode<T>> adjVertex = vertexMap.get(vertex);
            for (GraphNode<T> v : adjVertex) {
                System.out.println(vertex.getId()+ "-->"+ v.getId());
            }
            System.out.println();
        }
    }


}
