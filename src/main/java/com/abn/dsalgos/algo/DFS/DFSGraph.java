package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.ds.graph.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DFSGraph {

    List<Integer> result = new ArrayList<>();
    public List<Integer> dfs(Graph graph, int vertex) {

        boolean[] isVisited = new boolean[graph.getVertices()];

        if (!isVisited[vertex]) {
            return dfsHelper(graph, vertex, isVisited);
        }
        return null;
    }

    private List<Integer> dfsHelper(Graph graph, int source, boolean[] isVisited) {
        isVisited[source] = true;
        result.add(source);

        Iterator<Integer> iterator = graph.getAdjacentList()[source].listIterator();
        while (iterator.hasNext()) {

            int temp = iterator.next();
            if (!isVisited[temp]) {
                dfsHelper(graph, temp, isVisited);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(1, 4);

        DFSGraph dfsGraph = new DFSGraph();
        List<Integer> list = dfsGraph.dfs(graph, 0);

        System.out.println(list);
    }
}

