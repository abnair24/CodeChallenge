package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.ds.graph.Graph;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class GraphNodesCountInLevelTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 6);

        list.add(new Object[] {graph, 1, 0, 1});
        list.add(new Object[] {graph, 2, 0, 2});
        list.add(new Object[] {graph, 3, 0, 4});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(Graph graph, int level, int source, int expected) {
        GraphNodesCountInLevel graphNodesCountInLevel = new GraphNodesCountInLevel();
        Assert.assertEquals(graphNodesCountInLevel.nodeCountInLevel(level, source, graph), expected);
    }
}
