package com.abn.sc.dsa.day74;

import java.util.LinkedList;
import java.util.Queue;

/*
There is a rectangle with left bottom as (0, 0) and right up as (x, y).

There are N circles such that their centers are inside the rectangle.

Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y)
without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the
rectangle at any point of time.

Input 1:

 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]

 Output 1:

 NO

 Input 2:

 x = 3
 y = 3
 N = 1
 R = 1
 A = [0]
 B = [3]

 Output 2:

 YES
 Explanation 2:

 There is many valid paths in this case.
 One of the path is (0, 0) -> (1, 0) -> (2, 0) -> (3, 0) -> (3, 1) -> (3, 2) -> (3, 3).
 */
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ValidPath {

    private static boolean isBlocked(int px, int py, int radius, int[] circleX, int[] circleY) {
        for (int i = 0; i < circleX.length; i++) {
            double distance = Math.sqrt(Math.pow(px - circleX[i], 2) + Math.pow(py - circleY[i], 2));
            if (distance <= radius) {
                return true;
            }
        }
        return false;

    }

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        // A = x (rectangle width), B = y (rectangle height)
        // C = N (number of circles), D = R (radius)
        // E = x coordinates of circles, F = y coordinates of circles

        // If start or end point is blocked, no path exists
        if (isBlocked(0, 0, D, E, F) || isBlocked(A, B, D, E, F)) {
            return "NO";
        }

        // BFS to find path from (0,0) to (A,B)
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[A + 1][B + 1];

        // 8 directions: right, left, up, down, and 4 diagonals
        int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // Check if we reached destination
            if (current.x == A && current.y == B) {
                return "YES";
            }

            // Explore all 8 adjacent neighbors
            for (int i = 0; i < 8; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                // Check if within rectangle bounds
                if (newX >= 0 && newX <= A && newY >= 0 && newY <= B) {
                    // Check if not visited and not blocked by any circle
                    if (!visited[newX][newY] && !isBlocked(newX, newY, D, E, F)) {
                        visited[newX][newY] = true;
                        queue.offer(new Point(newX, newY));
                    }
                }
            }
        }

        // No path found
        return "NO";
    }
}
