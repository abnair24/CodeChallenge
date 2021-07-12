package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.ds.graph.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
Calculate the Number of Nodes in a Given Graph Level
 */
public class GraphNodesCountInLevel {

    boolean[] isVisited;

    public int nodeCountInLevel(int level, int source, Graph graph) {

        isVisited = new boolean[graph.getVertices()];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        isVisited[source] = true;

        int l = 1;
        int count = 0;

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();

            if (l == level) {
                count = nodeCount;
            }
            while (nodeCount > 0) {
                int temp = queue.poll();
                Iterator<Integer> iterator = graph.getAdjacentList()[temp].listIterator();
                while (iterator.hasNext()) {
                    int n = iterator.next();
                    if (!isVisited[n]) {
                        queue.add(n);
                        isVisited[n] = true;
                    }
                }
                nodeCount--;
            }
            l++;
        }
        return count;
    }
}
