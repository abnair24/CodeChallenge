package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.*;

public class BinaryTreeLowestCommonAncestor<T> {

    MyTreeNode<T> root;

    public BinaryTreeLowestCommonAncestor() {
        root = null;
    }

    public MyTreeNode lowestCommonAncestor(MyTreeNode<T> root,MyTreeNode<T> node1, MyTreeNode<T>node2 ) {
        Queue<MyTreeNode<T>> queue = new LinkedList<>();
        Map<MyTreeNode<T>,MyTreeNode<T>> parent = new HashMap<>();
        List<MyTreeNode<T>> parentArray = new ArrayList<>();
        MyTreeNode<T> current;

        queue.add(root);
        parent.put(root, null);

        while(!parent.containsKey(node1) || !parent.containsKey(node2)) {
            current = queue.poll();

            if(current.left != null) {
                parent.put(current.left,current);
                queue.add(current.left);
            }
            if(current.right != null) {
                parent.put(current.right,current);
                queue.add(current.right);
            }
        }

        while(node1 != null) {
            parentArray.add(node1);
            node1 = parent.get(node1);
        }
        while(!parentArray.contains(node2)) {
            node2 = parent.get(node2);
        }
        return node2;
    }
}
