package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreePathFromRootToNode2<T> {

    MyTreeNode<T> root;

    public BinaryTreePathFromRootToNode2() {
        root = null;
    }

    public void getPath(MyTreeNode<T> root, MyTreeNode<T> node) {
        Queue<MyTreeNode<T>> ds = new LinkedList<>();
        Map<MyTreeNode<T>, MyTreeNode<T>> parent = new HashMap<>();
        List<MyTreeNode<T>> parentArray = new ArrayList<>();

        MyTreeNode<T> current;

        ds.add(root);
        parent.put(root, null);

        while (!parent.containsKey(node)) {
            current = ds.poll();
            if (current.left != null) {
                parent.put(current.left, current);
                ds.add(current.left);
            }
            if (current.right != null) {
                parent.put(current.right, current);
                ds.add(current.right);
            }
        }

        while (node != null) {
            parentArray.add(node);
            node = parent.get(node);
        }

        Collections.reverse(parentArray);

        for (MyTreeNode<T> n : parentArray) {
            System.out.print(" ->" + n.data);
        }
    }
}
