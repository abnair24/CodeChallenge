package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.ds.graph.Graph;
import org.testng.annotations.Test;

import java.util.List;

public class BFSGraphTest {

    @Test
    public void test() {
        Graph graph = new Graph(5);

        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        BFSGraph bfsGraph = new BFSGraph();
        List<Integer> list = bfsGraph.BFS(graph);
        list.stream().toArray();
    }
}
