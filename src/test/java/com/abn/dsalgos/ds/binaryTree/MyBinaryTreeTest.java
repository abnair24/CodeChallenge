package com.abn.dsalgos.ds.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class MyBinaryTreeTest {

    private MyBinaryTree<Integer>myBinaryTree = new MyBinaryTree<>();

    @Test
    public void test() throws Exception {
        myBinaryTree.root = new MyTreeNode(1);
        myBinaryTree.root.left = new MyTreeNode(3);
        myBinaryTree.root.left.left = new MyTreeNode(4);
        myBinaryTree.root.left.right = new MyTreeNode(2);
        myBinaryTree.root.right = new MyTreeNode(7);
        myBinaryTree.root.right.left = new MyTreeNode(0);

        myBinaryTree.inOrder(myBinaryTree.root);
    }
}
