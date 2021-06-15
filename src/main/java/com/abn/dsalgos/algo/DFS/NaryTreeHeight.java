package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.NaryNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Find the height of an n-ary tree.
 */

public class NaryTreeHeight {

    private int max = 0;

    //Top down recursion
    public int naryHeightTopDown(NaryNode root) {
        return height(root, 0);
    }

    private int height(NaryNode root, int depth) {

        if (root == null) {
            return 0;
        }

        max = Math.max(max, depth + 1);

        for (NaryNode child : root.children) {
            return height(child, depth + 1);
        }
        return max;
    }

    // Bottom up recursion
    public int naryHeightBottomUp(NaryNode root) {

        if(root == null) {
           return 0;
        }

        int currentHeight = 0;

        for(NaryNode child : root.children) {
            currentHeight = Math.max(currentHeight, naryHeightBottomUp(child));
        }

        return 1 + currentHeight;
    }

    // Iterative approach
    public int naryHeightIterative(NaryNode root) {

        Queue<NaryNode> queue = new LinkedList<>();

        queue.add(root);
        int height = 0;

        while(!queue.isEmpty()) {
            int nodeCount = queue.size();
            height ++;
            while(nodeCount > 0) {
                NaryNode current = queue.remove();

                for(NaryNode child : current.children) {
                    queue.add(child);
                }
                nodeCount --;
            }
        }

        return height;
    }
}
