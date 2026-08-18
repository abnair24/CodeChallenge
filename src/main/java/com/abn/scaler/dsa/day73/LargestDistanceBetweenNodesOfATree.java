package com.abn.scaler.dsa.day73;

import java.util.ArrayList;

/*
Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.

The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a
number of edges on a
path between the nodes (there will be a unique path between any pair of nodes since it is a tree).

The nodes will be numbered 0 through N - 1.

The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N). Exactly one of the
i's will have A[i] equal to -1, it will be root node.

Input 1:


A = [-1, 0]
Input 2:


A = [-1, 0, 0]


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 Path is 0 -> 1.
Explanation 2:

 Path is 1 -> 0 -> 2.
 */
public class LargestDistanceBetweenNodesOfATree {

    private int maxDistance = 0;

    public int solve(int[] A) {

        int n = A.length;
        ArrayList<ArrayList<Integer>> children = new ArrayList<>();
        int root = -1;

        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (A[i] == -1) {
                root = i;
            } else {
                children.get(A[i]).add(i);
            }
        }

        dfs(root, children);

        return maxDistance;
    }

    private int dfs(int node, ArrayList<ArrayList<Integer>> children) {
        if (children.get(node).isEmpty()) {
            return 0;
        }


        int maxHeight1 = 0;
        int maxHeight2 = 0;

        for (int child : children.get(node)) {
            int height = dfs(child, children) + 1;
            if (height > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = height;
            } else if (height > maxHeight2) {
                maxHeight2 = height;
            }
        }

        int diameterThroughNode = maxHeight1 + maxHeight2;

        maxDistance = Math.max(maxDistance, diameterThroughNode);

        return maxHeight1;
    }

    public static void main(String[] args) {
        LargestDistanceBetweenNodesOfATree solution = new LargestDistanceBetweenNodesOfATree();
        int[] A1 = {-1, 0};
        int[] A2 = {-1, 0, 0};

        System.out.println(solution.solve(A1)); // Output: 1
        System.out.println(solution.solve(A2)); // Output: 2
    }
}
