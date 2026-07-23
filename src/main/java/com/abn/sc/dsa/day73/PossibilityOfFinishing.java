package com.abn.sc.dsa.day73;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
There are a total of A courses you have to take, labeled from 1 to A.

Some courses may have prerequisites, for example to take course 2 you have to first take course 1,
which is expressed as a pair: [1,2].

So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

Input 1:

 A = 3
 B = [1, 2]
 C = [2, 3]

 Output 1:
 1

 Input 2:

 A = 2
 B = [1, 2]
 C = [2, 1]

Output 2:

 0
 */
public class PossibilityOfFinishing {

    public int solve(int A, int[] B, int[] C) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[A + 1];

        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            graph.get(B[i]).add(C[i]);
            inDegree[C[i]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processedCourses = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            processedCourses++;

            // Reduce in-degree of all neighbors
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return processedCourses == A ? 1 : 0;
    }
}
