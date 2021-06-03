package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;
import com.google.common.collect.Lists;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.List;


public class BinaryTreeSumOfPathNumbersTest {

    BinaryTreeSumOfPathNumbers binaryTree = new BinaryTreeSumOfPathNumbers();

    @DataProvider
    public Iterator<Object[]> data() {

        List<Object[]> lst = Lists.newLinkedList();

        MyTreeNode<Integer> node1 = new MyTreeNode<>(1);
        MyTreeNode<Integer> node2 = new MyTreeNode<>(7);
        MyTreeNode<Integer> node3 = new MyTreeNode<>(9);
        MyTreeNode<Integer> node4 = new MyTreeNode<>(8);
        MyTreeNode<Integer> node5 = new MyTreeNode<>(5);
        MyTreeNode<Integer> node6 = new MyTreeNode<>(2);
        MyTreeNode<Integer> node7 = new MyTreeNode<>(9);

        binaryTree.root = node1;
        binaryTree.root.left = node2;
        binaryTree.root.right = node3;
        binaryTree.root.left.left = node4;
        binaryTree.root.left.right = node5;
        binaryTree.root.right.left = node6;
        binaryTree.root.right.right = node7;

        lst.add(new Object[] {binaryTree, 744});
        return lst.iterator();
    }


    @Test (dataProvider = "data")
    public void test(BinaryTreeSumOfPathNumbers binaryTree, int expected ) {
        Assert.assertEquals(binaryTree.getPathSum(), expected);
    }
}
