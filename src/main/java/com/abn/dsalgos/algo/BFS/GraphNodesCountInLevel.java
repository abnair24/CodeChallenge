package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.ds.graph.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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

            while (nodeCount > 0) {
                if (l == level) {
                    count = nodeCount;
                }

                int temp = queue.poll();
                Iterator<Integer> iterator = graph.getAdjacentList()[temp].listIterator();
                while (iterator.hasNext()) {
                    int n = iterator.next();
                    if (!isVisited[n]) {
                        queue.add(n);
                        isVisited[n] = true;
                    }
                }
                nodeCount -- ;
            }
            l++;
        }
        return count;
    }

        public static void main (String[]args){
            Graph graph = new Graph(6);
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 3);
            graph.addEdge(2, 3);
            graph.addEdge(3, 5);
            graph.addEdge(2, 4);

            System.out.println(new GraphNodesCountInLevel().nodeCountInLevel(3, 0, graph));
        }
    }
