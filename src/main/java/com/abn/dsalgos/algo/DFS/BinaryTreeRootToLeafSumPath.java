package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;
import com.google.common.collect.Lists;
import org.testng.collections.Maps;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/*
To print all path from roof to leaf which has sum equal to given sum

 Eg:          1
           7     9
        4    5  2  7

        sum = 12
        o/p : [1,7,4,1,9,2]
 */

public class BinaryTreeRootToLeafSumPath {

    MyTreeNode<Integer> root;

    public BinaryTreeRootToLeafSumPath() {
        root = null;
    }

    public List<Integer> getPath(int sum) {

        /*
        nodeQueue : Stores nodes
         */
        Queue<MyTreeNode<Integer>> nodeQueue = Lists.newLinkedList();

        /*
        valueQueue : Stores sum at each node
         */
        Queue<Integer> valueQueue = Lists.newLinkedList();

        /*
        parent : Stores parent of each node
         */
        Map<MyTreeNode<Integer>, MyTreeNode<Integer>> parent = Maps.newHashMap();

        /*
        parentArray : Stores entire path
         */
        List<Integer> parentArray;

        /*
        resultArray : Stores list of paths
         */

        List<List<Integer>> resultArray = Lists.newArrayList();

        MyTreeNode<Integer> current;

        nodeQueue.add(root);
        valueQueue.add(root.data);
        parent.put(root, null);

        while (!nodeQueue.isEmpty()) {
            current = nodeQueue.poll();
            int sumValue = valueQueue.poll();

            if (current.left != null) {
                nodeQueue.add(current.left);
                valueQueue.add(sumValue + (int) current.left.data);
                parent.put(current.left, current);
            }
            if (current.right != null) {
                nodeQueue.add(current.right);
                valueQueue.add(sumValue + (int) current.right.data);
                parent.put(current.right, current);
            }

            if (current.left == null && current.right == null && sumValue == sum) {
                parentArray = Lists.newArrayList();
                while (current != null) {
                    parentArray.add(current.data);
                    current = parent.get(current);
                }

                Collections.reverse(parentArray);

                resultArray.add(parentArray);
            }
        }

        // Return as a flat List instead of List<List<Integer>>
        return resultArray.stream().flatMap(Collection::stream).collect(Collectors.toList());

    }
}
