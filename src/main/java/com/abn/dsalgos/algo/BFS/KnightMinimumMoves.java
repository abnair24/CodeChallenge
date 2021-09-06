package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction,
then one square in an orthogonal direction.

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]

 */

public class KnightMinimumMoves {

    int[][] DIRECTIONS = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public int minKnightMoves(int x, int y) {

        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        Pair start = new Pair(0, 0);
        queue.add(start);
        visited.add(start);

        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Pair current = queue.poll();

                if (current.row == x && current.col == y) {
                    return level;
                }

                for (Pair neighbour : getNeigbours(current)) {
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

    private List<Pair> getNeigbours(Pair node) {

        List<Pair> result = new ArrayList<>();

        for (int[] dir : DIRECTIONS) {
            int x = dir[0] + node.row;
            int y = dir[1] + node.col;

            result.add(new Pair(x, y));
        }
        return result;
    }
}
