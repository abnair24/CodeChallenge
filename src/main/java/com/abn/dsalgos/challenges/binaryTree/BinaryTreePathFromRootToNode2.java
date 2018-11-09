package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.*;

public class BinaryTreePathFromRootToNode2<T> {

    MyTreeNode<T> root;

    public BinaryTreePathFromRootToNode2() {
        root = null;
    }

    public void getPath(MyTreeNode<T> root, MyTreeNode<T> node) {
        Stack<MyTreeNode<T>> stack = new Stack<>();
        Map<MyTreeNode<T>,MyTreeNode<T>> parent = new HashMap<>();
        List<MyTreeNode<T>> parentArray = new ArrayList<>();

        MyTreeNode<T> current;

        stack.add(root);
        parent.put(root, null);

        while(!parent.containsKey(node)) {
            current = stack.pop();
            if(current.left != null) {
                parent.put(current.left, current);
                stack.add(current.left);
            }
            if(current.right != null){
                parent.put(current.right,current);
                stack.add(current.right);
            }
        }

        while(node != null) {
            parentArray.add(node);
            node = parent.get(node);
        }

        Collections.reverse(parentArray);

        for(MyTreeNode<T> n : parentArray) {
            System.out.print( " ->"+n.data);
        }
    }
}
