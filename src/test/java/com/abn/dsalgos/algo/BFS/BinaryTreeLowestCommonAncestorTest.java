package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryTreeLowestCommonAncestorTest {

    BinaryTreeLowestCommonAncestor<Integer> binaryTreeLowestCommonAncestor = new BinaryTreeLowestCommonAncestor<>();

    @Test
    public void test()
            throws Exception {
        MyTreeNode<Integer> node1 = new MyTreeNode<>(1);
        MyTreeNode<Integer> node2 = new MyTreeNode<>(2);
        MyTreeNode<Integer> node3 = new MyTreeNode<>(4);
        MyTreeNode<Integer> node4 = new MyTreeNode<>(3);
        MyTreeNode<Integer> node5 = new MyTreeNode<>(5);
        MyTreeNode<Integer> node6 = new MyTreeNode<>(6);
        MyTreeNode<Integer> node7 = new MyTreeNode<>(7);
        MyTreeNode<Integer> node8 = new MyTreeNode<>(8);

        binaryTreeLowestCommonAncestor.root = node1;
        binaryTreeLowestCommonAncestor.root.left = node2;
        binaryTreeLowestCommonAncestor.root.left.right = node3;
        binaryTreeLowestCommonAncestor.root.right = node4;
        binaryTreeLowestCommonAncestor.root.right.left = node5;
        binaryTreeLowestCommonAncestor.root.right.right = node6;
        binaryTreeLowestCommonAncestor.root.right.left.left = node7;
        binaryTreeLowestCommonAncestor.root.right.left.right = node8;

        Assert.assertEquals(binaryTreeLowestCommonAncestor.lowestCommonAncestor(node1, node6, node7), node4);
        Assert.assertEquals(binaryTreeLowestCommonAncestor.lowestCommonAncestor(node1, node5, node8), node5);
        Assert.assertEquals(binaryTreeLowestCommonAncestor.lowestCommonAncestor(node1, node4, node6), node4);
        Assert.assertEquals(binaryTreeLowestCommonAncestor.lowestCommonAncestor(node1, node2, node5), node1);
        Assert.assertEquals(binaryTreeLowestCommonAncestor.lowestCommonAncestor(node1, node4, node7), node4);
    }

    @Test
    public void test1()
            throws Exception {
        MyTreeNode<Integer> node1 = new MyTreeNode<>(3);
        MyTreeNode<Integer> node2 = new MyTreeNode<>(5);
        MyTreeNode<Integer> node3 = new MyTreeNode<>(1);
        MyTreeNode<Integer> node4 = new MyTreeNode<>(6);
        MyTreeNode<Integer> node5 = new MyTreeNode<>(2);
        MyTreeNode<Integer> node6 = new MyTreeNode<>(0);
        MyTreeNode<Integer> node7 = new MyTreeNode<>(8);
        MyTreeNode<Integer> node8 = new MyTreeNode<>(7);
        MyTreeNode<Integer> node9 = new MyTreeNode<>(4);

        binaryTreeLowestCommonAncestor.root = node1;
        binaryTreeLowestCommonAncestor.root.left = node2;
        binaryTreeLowestCommonAncestor.root.right = node3;
        binaryTreeLowestCommonAncestor.root.left.left = node4;
        binaryTreeLowestCommonAncestor.root.left.right = node5;
        binaryTreeLowestCommonAncestor.root.left.right.left = node8;
        binaryTreeLowestCommonAncestor.root.left.right.right = node9;
        binaryTreeLowestCommonAncestor.root.right.left = node6;
        binaryTreeLowestCommonAncestor.root.right.right = node7;

        Assert.assertEquals(binaryTreeLowestCommonAncestor.lowestCommonAncestor(node1, node2, node3), node1);
    }
}
