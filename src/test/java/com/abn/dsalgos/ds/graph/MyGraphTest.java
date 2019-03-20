package com.abn.dsalgos.ds.graph;

import com.abn.dsalgos.utils.GraphNode;
import org.testng.annotations.Test;

public class MyGraphTest {

    @Test
    public void test1() throws Exception {
        MyGraph<Integer> myGraph = new MyGraph<>();

        GraphNode<Integer> one = new GraphNode<>(1);
        GraphNode<Integer> two = new GraphNode<>(2);
        GraphNode<Integer> three = new GraphNode<>(3);
        GraphNode<Integer> four = new GraphNode<>(4);
        GraphNode<Integer> five = new GraphNode<>(5);
        GraphNode<Integer> six = new GraphNode<>(6);

        myGraph.addEdge(one,two);
        myGraph.addEdge(one,five);
        myGraph.addEdge(two,three);
        myGraph.addEdge(two,six);
        myGraph.addEdge(three,four);
        myGraph.addEdge(five,six);
        myGraph.addEdge(four,six);

        System.out.println(myGraph.getVertices());

        myGraph.printGraph();

        myGraph.removeVertex(two);

        System.out.println(myGraph.getVertices());

        myGraph.printGraph();
    }
}
