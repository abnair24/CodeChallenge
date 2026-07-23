package com.abn.sc.dsa.day59;

import java.util.HashMap;
import java.util.Map;

/*
Max Heap is a special kind of complete binary tree in which, for every node,
the value present in that node is greater than the value present in its children nodes.

Find the number of distinct Max Heap that can be made from A distinct integers.

In short, you have to ensure the following properties for the max heap :

Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level,
except possibly the last, is completely filled, and all nodes are as far left as possible.)
Every node is greater than all its children.
NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 109 + 7.
 */
public class WaysToFormMaxHeap {

    private static final int MOD = 1000000007;
    private static long[][] C; // Pascal's triangle for combinations
    private static Map<Integer, Integer> memo; // Memoization for heap count

    public int solve(int A) {

        if (A <= 1) return 1;

        // Initialize global data structures
        initializeCombinations(A);
        memo = new HashMap<>();

        return find(A);
    }

    private static int find(int n) {
        if (n <= 1) return 1;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // For a complete binary tree with n nodes:
        // 1. Root is the maximum element (fixed)
        // 2. Remaining (n-1) elements go to left and right subtrees

        int leftSize = getLeftSubtreeSize(n);
        int rightSize = n - 1 - leftSize;

        // Number of ways to choose leftSize elements from (n-1) elements for left subtree
        long ways = C[n-1][leftSize];

        // Recursively count heaps for left and right subtrees
        long leftHeaps = find(leftSize);
        long rightHeaps = find(rightSize);

        long result = (ways * leftHeaps) % MOD;
        result = (result * rightHeaps) % MOD;

        memo.put(n, (int)result);
        return (int)result;
    }

    /**
     * Calculate the size of left subtree in a complete binary tree with n nodes
     */
    private static int getLeftSubtreeSize(int n) {
        if (n <= 1) return 0;

        // Height of the tree
        int h = (int)(Math.log(n) / Math.log(2));

        // Maximum nodes in a complete binary tree of height h-1
        int maxNodesInHMinus1 = (1 << h) - 1;

        // Nodes in the last level
        int lastLevelNodes = n - maxNodesInHMinus1;

        // Maximum possible nodes in left subtree's last level
        int maxLastLevelLeft = 1 << (h - 1);

        // Actual nodes in left subtree's last level
        int actualLastLevelLeft = Math.min(lastLevelNodes, maxLastLevelLeft);

        // Total nodes in left subtree
        int leftSubtreeSize = (1 << (h - 1)) - 1 + actualLastLevelLeft;

        return leftSubtreeSize;
    }

    /**
     * Initialize Pascal's triangle for computing combinations C(n,k)
     */
    private static void initializeCombinations(int n) {
        C = new long[n + 1][n + 1];

        // Base cases
        for (int i = 0; i <= n; i++) {
            C[i][0] = 1;
            if (i < C[i].length) {
                C[i][i] = 1;
            }
        }

        // Fill Pascal's triangle
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                C[i][j] = (C[i-1][j-1] + C[i-1][j]) % MOD;
            }
        }
    }
}
