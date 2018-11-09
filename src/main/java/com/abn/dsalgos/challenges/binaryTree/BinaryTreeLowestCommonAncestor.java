package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.*;

public class BinaryTreeLowestCommonAncestor<T> {

    MyTreeNode<T> root;

    public BinaryTreeLowestCommonAncestor() {
        root = null;
    }

    public T lowestCommonAncestor(MyTreeNode<T> root,MyTreeNode<T> node1, MyTreeNode<T>node2 ) {
        Stack<MyTreeNode<T>> stack = new Stack<>();
        Map<MyTreeNode<T>,MyTreeNode<T>> parent = new HashMap<>();
        List<MyTreeNode<T>> parentArray = new ArrayList<>();
        MyTreeNode<T> current;

        stack.add(root);
        parent.put(root, null);

        while(!parent.containsKey(node1) || !parent.containsKey(node2)) {
            current = stack.pop();

            if(current.left != null) {
                parent.put(current.left,current);
                stack.add(current.left);
            }
            if(current.right != null) {
                parent.put(current.right,current);
                stack.add(current.right);
            }
        }

        while(node1 != null) {
            parentArray.add(node1);
            node1 = parent.get(node1);
        }
        while(!parentArray.contains(node2)) {
            node2 = parent.get(node2);
        }
        return node2.data;
    }
}
