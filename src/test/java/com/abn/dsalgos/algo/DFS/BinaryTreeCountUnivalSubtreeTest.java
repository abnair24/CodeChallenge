package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryTreeCountUnivalSubtreeTest {

    @Test
    public void test1()
            throws Exception {

        MyTreeNode<Integer> root = new MyTreeNode<>(5);
        root.left = new MyTreeNode<>(5);
        root.right = new MyTreeNode<>(5);
        root.left.left = new MyTreeNode<>(5);
        root.left.right = new MyTreeNode<>(5);
        root.left.left.left = new MyTreeNode<>(4);
        root.left.left.right = new MyTreeNode(3);
        root.right.right = new MyTreeNode<>(5);

        BinaryTreeCountUnivalSubtree binaryTreeCountUnivalSubtree = new BinaryTreeCountUnivalSubtree();
        Assert.assertEquals(binaryTreeCountUnivalSubtree.countUnivalSubtrees(root), 5);
    }

    @Test
    public void test2()
            throws Exception {

        MyTreeNode<Integer> root = new MyTreeNode<>(5);
        root.left = new MyTreeNode<>(1);
        root.right = new MyTreeNode<>(5);
        root.left.left = new MyTreeNode<>(5);
        root.left.right = new MyTreeNode<>(5);
        root.right.right = new MyTreeNode<>(5);

        BinaryTreeCountUnivalSubtree binaryTreeCountUnivalSubtree = new BinaryTreeCountUnivalSubtree();
        Assert.assertEquals(binaryTreeCountUnivalSubtree.countUnivalSubtrees(root), 4);
    }

    @Test
    public void test3()
            throws Exception {

        MyTreeNode<Integer> root = new MyTreeNode<>(5);

        BinaryTreeCountUnivalSubtree binaryTreeCountUnivalSubtree = new BinaryTreeCountUnivalSubtree();
        Assert.assertEquals(binaryTreeCountUnivalSubtree.countUnivalSubtrees(root), 1);
    }
}
