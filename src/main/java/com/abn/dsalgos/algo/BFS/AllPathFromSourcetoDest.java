package com.abn.dsalgos.algo.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathFromSourcetoDest {

    public List<List<Integer>> getPaths(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0));

        int dest = graph.length - 1;
        while (!queue.isEmpty()) {

            List<Integer> path = queue.poll();
            int lastElement = path.get(path.size() - 1);

            if (lastElement == dest) {
                result.add(new ArrayList<>(path));
            } else {

                // lastelement in the queue list neighbours.
                int[] adjListNodes = graph[lastElement];

                for (int adj : adjListNodes) {

                    // create list with existing path ie; starting from 0. Add new members
                    List<Integer> lists = new ArrayList<>(path);
                    lists.add(adj);
                    queue.add(lists);
                }
            }
        }

        return result;
    }
}
