package com.abn.scalar.dsa.day55;

import com.abn.dsalgos.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.

            6
           / \
          3   7
         / \   \
        2   5   9


Vertical 1: 2
Vertical 2: 3
Vertical 3: 6,5
Vertical 4: 7
Vertical 5: 9
 */

public class VerticalTraversalBT {

    public ArrayList<ArrayList<Integer>> solve(TreeNode root) {

        int min = 0;
        int max = 0;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()) {

            Pair current = queue.poll();
            ArrayList<Integer> levelList;

            if(map.containsKey(current.level)) {
                levelList = map.get(current.level);
            } else {
                levelList = new ArrayList<>();
            }

            levelList.add(current.node.val);
            map.put(current.level, levelList);

            min = Math.min(min, current.level);
            max = Math.max(max, current.level);

            if (current.node.left != null) {
                queue.add(new Pair(current.node.left, current.level - 1));
            }

            if (current.node.right != null) {
                queue.add(new Pair(current.node.right, current.level + 1));
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = min; i <= max; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    public static void main(String[] args) {

        VerticalTraversalBT verticalTraversalBT = new VerticalTraversalBT();
        TreeNode root = new TreeNode(3709);
        root.left = new TreeNode(4465);
        root.right = new TreeNode(2668);
        verticalTraversalBT.solve(root);
    }
}
