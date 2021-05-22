package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BinaryTreeBFSTest {

    private BinaryTreeBFS<Integer> binaryTreeBFS = new BinaryTreeBFS<>();

    @Test
    public void test() throws Exception {
        binaryTreeBFS.root = new MyTreeNode<>(1);
        binaryTreeBFS.root.left = new MyTreeNode<>(2);
        binaryTreeBFS.root.right = new MyTreeNode<>(3);
        binaryTreeBFS.root.left.left = new MyTreeNode<>(4);
        binaryTreeBFS.root.left.right = new MyTreeNode<>(5);

        binaryTreeBFS.root.right.left = new MyTreeNode<>(6);
        binaryTreeBFS.root.right.right = new MyTreeNode<>(7);

        binaryTreeBFS.breadthFirstSearch(binaryTreeBFS.root);
    }
}
