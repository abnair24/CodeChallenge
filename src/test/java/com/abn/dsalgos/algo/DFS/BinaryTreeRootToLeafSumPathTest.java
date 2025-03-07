package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryTreeRootToLeafSumPathTest {

    BinaryTreeRootToLeafSumPath binaryTree = new BinaryTreeRootToLeafSumPath();

    @DataProvider
    public Iterator<Object[]> data() {

        List<Object[]> lst = Lists.newLinkedList();

        MyTreeNode<Integer> node1 = new MyTreeNode<>(5);
        MyTreeNode<Integer> node2 = new MyTreeNode<>(4);
        MyTreeNode<Integer> node3 = new MyTreeNode<>(8  );
        MyTreeNode<Integer> node4 = new MyTreeNode<>(11);
        MyTreeNode<Integer> node5 = new MyTreeNode<>(7);
        MyTreeNode<Integer> node6 = new MyTreeNode<>(2);
        MyTreeNode<Integer> node7 = new MyTreeNode<>(13);
        MyTreeNode<Integer> node8 = new MyTreeNode<>(4);
        MyTreeNode<Integer> node9 = new MyTreeNode<>(1);
        MyTreeNode<Integer> node10 = new MyTreeNode<>(5);

        binaryTree.root = node1;
        binaryTree.root.left = node2;
        binaryTree.root.right = node3;
        binaryTree.root.left.left = node4;
        binaryTree.root.left.left.left = node5;
        binaryTree.root.left.left.right = node6;
        binaryTree.root.right.left = node7;
        binaryTree.root.right.right = node8;
        binaryTree.root.right.right.right = node9;
        binaryTree.root.right.right.left = node10;

        lst.add(new Object[] {binaryTree, 22, Stream.of(Ints.asList(5,4,11,2),
                Ints.asList(5,8,4,5))
                .flatMap(Collection::stream)
                .collect(Collectors.toList())});
        lst.add(new Object[] {binaryTree, 26, Stream.of(Ints.asList(5, 8, 13))
                .flatMap(Collection::stream)
                .collect(Collectors.toList())});
        lst.add(new Object[] {binaryTree, 4, Lists.newArrayList()});

        return lst.iterator();
    }

    @Test(dataProvider = "data")
    public void test(BinaryTreeRootToLeafSumPath binaryTree, int sum, List<Integer> expected ) throws Exception{

        Assert.assertEquals(binaryTree.getPath(sum), expected);
    }
}
