package com.abn.sc.dsa.day74;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.

1 represents a wall in a matrix and 0 represents an empty location in a wall.

There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right,
but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops,
it could choose the next direction.

Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.

Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty
 spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball
  cannot stop at the destination, return -1.

  Input 1:

A = [ [0, 0],
      [0, 0] ]
B = [0, 0]
C = [0, 1]

Output 1:
 1

Input 2:

A = [ [0, 1],
      [1, 0] ]
B = [0, 0]
C = [1, 1]

Output 2:

 -1

 */
public class MazeShortestDistance {

    public int solve(int[][] A, int[] B, int[] C) {

        int N = A.length;
        int M = A[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{B[0], B[1], 0});
        distance[B[0]][B[1]] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];

            if (dist > distance[row][col]) {
                continue;
            }

            for (int[] dir : directions) {
                int newRow = row;
                int newCol = col;
                int steps = 0;

                while (newRow + dir[0] >= 0 && newRow + dir[0] < N && newCol + dir[1] >= 0 && newCol + dir[1] < M && A[newRow + dir[0]][newCol + dir[1]] == 0)
                {
                    newRow += dir[0];
                    newCol += dir[1];
                    steps++;
                }
                int newDist = dist + steps;
                if (newDist < distance[newRow][newCol]) {
                    distance[newRow][newCol] = newDist;
                    pq.offer(new int[]{newRow, newCol, newDist});
                }
            }
        }

        // Return the distance to destination, or -1 if unreachable
        return distance[C[0]][C[1]] == Integer.MAX_VALUE ? -1 : distance[C[0]][C[1]];
    }
}
