package com.abn.dsalgos.ds.graph;

import org.testng.annotations.Test;

public class MyGraphTest {

    @Test
    public void test1() throws Exception {
        MyGraph<Integer> myGraph = new MyGraph<>();

        myGraph.addEdge(1,2);
        myGraph.addEdge(1,5);
        myGraph.addEdge(2,3);
        myGraph.addEdge(2,6);
        myGraph.addEdge(3,4);
        myGraph.addEdge(5,6);
        myGraph.addEdge(4,6);

        System.out.println(myGraph.getVertices());

        myGraph.printGraph();

        myGraph.removeVertex(2);

        System.out.println(myGraph.getVertices());

        myGraph.printGraph();
    }
}
