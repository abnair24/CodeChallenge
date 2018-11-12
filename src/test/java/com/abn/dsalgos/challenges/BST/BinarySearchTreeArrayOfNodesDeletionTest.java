package com.abn.dsalgos.challenges.BST;

import com.abn.dsalgos.utils.MyBSTNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinarySearchTreeArrayOfNodesDeletionTest {

    BinarySearchTreeArrayOfNodesDeletion<Integer> myBinarySearchTree = new BinarySearchTreeArrayOfNodesDeletion<>();

    @Test
    public void test() throws Exception {

        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(5));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(2));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(1));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(3));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(6));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(8));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(7));

        myBinarySearchTree.deleteArray(myBinarySearchTree.root,new int[]{4,5,6});
        System.out.println();

    }
}
