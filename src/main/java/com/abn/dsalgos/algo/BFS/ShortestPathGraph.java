package com.abn.dsalgos.algo.BFS;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
Given an (unweighted) graph, return the length of the shortest path between
two nodes A and B in terms of the number of edges.

graph: {
  0: [1, 2],
  1: [0, 2, 3],
  2: [0, 1, 4],
  3: [1, 4]
}
A: 0
B: 4

o/p : 2
 */
class MyGraphNode {
    int val;

    public MyGraphNode(int val) {
        this.val = val;
    }
}

public class ShortestPathGraph {

    private int bfs(Map<MyGraphNode, List<MyGraphNode>> graph, MyGraphNode source, MyGraphNode target) {

        Queue<MyGraphNode> queue = new LinkedList<>();
        queue.add(source);
        Set<MyGraphNode> visited = new HashSet<>();
        visited.add(source);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                MyGraphNode node = queue.poll();
                if (target.equals(node)) {
                    return level;
                }
                for (MyGraphNode neighbour : graph.get(node)) {
                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            level++;
        }

        return level;
    }

    public static void main(String[] args) {

        Map<MyGraphNode, List<MyGraphNode>> map = new HashMap<>();
        MyGraphNode node0 = new MyGraphNode(0);
        MyGraphNode node1 = new MyGraphNode(1);
        MyGraphNode node2 = new MyGraphNode(2);
        MyGraphNode node3 = new MyGraphNode(3);
        MyGraphNode node4 = new MyGraphNode(4);


        List<MyGraphNode> ll0 = new ArrayList<>();
        ll0.add(node1);
        ll0.add(node2);

        List<MyGraphNode> ll1 = new ArrayList<>();
        ll1.add(node0);
        ll1.add(node2);
        ll1.add(node3);

        List<MyGraphNode> ll2 = new ArrayList<>();
        ll2.add(node0);
        ll2.add(node1);
        ll2.add(node4);

        List<MyGraphNode> ll3 = new ArrayList<>();
        ll3.add(node1);
        ll3.add(node4);

        List<MyGraphNode> ll4 = new ArrayList<>();
        ll4.add(node2);
        ll3.add(node3);
        map.put(node0, ll0);
        map.put(node1, ll1);
        map.put(node2, ll2);
        map.put(node3, ll3);
        map.put(node4, ll4);

        ShortestPathGraph shortestPathGraph = new ShortestPathGraph();
        Assert.assertEquals(shortestPathGraph.bfs(map, node0, node4), 2);
    }
}
