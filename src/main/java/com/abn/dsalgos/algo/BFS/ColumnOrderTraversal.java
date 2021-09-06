package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

//TODO
public class ColumnOrderTraversal {

    public List<List<Integer>> columnOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        Queue<Integer> columnQueue = new LinkedList<>();
        Map<Integer, List<Integer>> columnMap = new TreeMap<>();

        int column = 0;
        queue.add(root);
        columnQueue.add(column);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);

        columnMap.put(column, list);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();
            int columnValue = columnQueue.poll();

            if (current != null && current.left != null) {
                queue.add(current.left);
                columnQueue.add(columnValue - 1);
                if (columnMap.containsKey(columnValue - 1)) {
                    columnMap.get(columnValue - 1).add(current.left.val);
                } else {
                    List<Integer> leftList = new ArrayList<>();
                    leftList.add(current.left.val);
                    columnMap.put(columnValue - 1, leftList);
                }
            }

            if (current != null && current.right != null) {
                queue.add(current.right);
                columnQueue.add(columnValue + 1);
                if (columnMap.containsKey(columnValue + 1)) {
                    columnMap.get(columnValue + 1).add(current.right.val);
                } else {
                    List<Integer> rightList = new ArrayList<>();
                    rightList.add(current.right.val);
                    columnMap.put(columnValue + 1, rightList);
                }
            }
        }

        for (Integer i : columnMap.keySet()) {
            List<Integer> list1 = columnMap.get(i);
            Collections.sort(list1);
            result.add(list1);
        }
        return result;
    }

    public static void main(String[] args) {

        ColumnOrderTraversal columnOrderTraversal = new ColumnOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        columnOrderTraversal.columnOrder(root);
    }
}
