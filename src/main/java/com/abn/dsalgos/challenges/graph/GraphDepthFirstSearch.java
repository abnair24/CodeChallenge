package com.abn.dsalgos.challenges.graph;

import com.abn.dsalgos.utils.GraphNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GraphDepthFirstSearch<T> {

    private Map<GraphNode<T>, List<GraphNode<T>>> vertexMap;
    private final HashSet<GraphNode<T>> vertices;

    public GraphDepthFirstSearch() {
        vertexMap = new ConcurrentHashMap<>();
        vertices = new HashSet<>();
    }

    public void addEdge(GraphNode<T> source, GraphNode<T> destination) {

        List<GraphNode<T>> adjVertices = vertexMap.get(source);

        if(adjVertices == null || adjVertices.isEmpty()) {
            adjVertices = new ArrayList<>();
            adjVertices.add(destination);
        } else {
            adjVertices.add(destination);
        }

        vertexMap.put(source,adjVertices);
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

    public void DFS(GraphNode<T> startNode) {

        if(startNode == null) {
            return;
        }

        Stack<GraphNode<T>> stack = new Stack<>();
        stack.push(startNode);
        startNode.visited = true;

        while(!stack.isEmpty()){
            GraphNode<T> temp = stack.pop();
            System.out.println(temp.data);

            List<GraphNode<T>> adjVertexList = vertexMap.get(temp);
            for(GraphNode<T> v : adjVertexList) {
                if(!v.visited) {
                    stack.push(v);
                    v.visited = true;
                }
            }
        }
    }

}
