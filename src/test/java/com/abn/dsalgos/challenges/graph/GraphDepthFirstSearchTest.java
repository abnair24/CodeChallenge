package com.abn.dsalgos.challenges.graph;

import com.abn.dsalgos.utils.GraphNode;
import org.testng.annotations.Test;

public class GraphDepthFirstSearchTest {

    @Test
    public void test1() throws Exception {
        GraphDepthFirstSearch<Integer> graph = new GraphDepthFirstSearch<>();

        GraphNode<Integer> one = new GraphNode<>(1);
        GraphNode<Integer> two = new GraphNode<>(2);
        GraphNode<Integer> three = new GraphNode<>(3);
        GraphNode<Integer> four = new GraphNode<>(4);
        GraphNode<Integer> five = new GraphNode<>(5);
        GraphNode<Integer> six = new GraphNode<>(6);
        GraphNode<Integer> seven = new GraphNode<>(7);

        graph.addEdge(one, two);
        graph.addEdge(one, four);
        graph.addEdge(two, three);
        graph.addEdge(two, five);
        graph.addEdge(two, one);
        graph.addEdge(three, seven);
        graph.addEdge(four, five);
        graph.addEdge(five, six);
        graph.addEdge(seven, six);
        graph.addEdge(six, seven);

        graph.DFS(two);
    }
}
