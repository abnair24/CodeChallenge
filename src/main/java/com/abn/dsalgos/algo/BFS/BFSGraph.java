package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.ds.graph.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {

    public List<Integer> BFS(Graph graph) {

        boolean[] isVisited = new boolean[graph.getVertices()];
        for(int i = 0; i < graph.getVertices(); i++) {

            if(!isVisited[i]) {
                return bfsHelper(graph, i, isVisited);
            }
        }
        return null;
    }

    private List<Integer> bfsHelper(Graph graph, int source, boolean[] isVisited) {

        Queue<Integer> queue = new LinkedList<>();

        List<Integer> result = new ArrayList<>();

        isVisited[source] = true;
        queue.add(source);

        while(!queue.isEmpty()) {

            int temp = queue.poll();
            result.add(temp);

            Iterator<Integer> iterator = graph.getAdjacentList()[temp].listIterator();
            while(iterator.hasNext()) {
                int n = iterator.next();

                if(!isVisited[n]) {
                    isVisited[n] = true;
                    queue.add(n);
                }
            }
        }
        return result;
    }
}
