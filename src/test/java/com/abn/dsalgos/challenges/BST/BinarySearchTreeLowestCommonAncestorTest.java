package com.abn.dsalgos.challenges.BST;

import com.abn.dsalgos.utils.MyBSTNode;
import org.testng.annotations.Test;

public class BinarySearchTreeLowestCommonAncestorTest {

    BinarySearchTreeLowestCommonAncestor<Integer> bst = new BinarySearchTreeLowestCommonAncestor<>();


    @Test()
    public void test() throws Exception {
        MyBSTNode<Integer> node1 = new MyBSTNode<>(40);
        MyBSTNode<Integer> node2 = new MyBSTNode<>(20);
        MyBSTNode<Integer> node3 = new MyBSTNode<>(60);
        MyBSTNode<Integer> node4 = new MyBSTNode<>(10);
        MyBSTNode<Integer> node5 = new MyBSTNode<>(30);
        MyBSTNode<Integer> node6 = new MyBSTNode<>(50);
        MyBSTNode<Integer> node7 = new MyBSTNode<>(70);
        MyBSTNode<Integer> node8 = new MyBSTNode<>(5);
        MyBSTNode<Integer> node9 = new MyBSTNode<>(55);

        bst.insertNode(node1);
        bst.insertNode(node2);
        bst.insertNode(node3);
        bst.insertNode(node4);
        bst.insertNode(node5);
        bst.insertNode(node6);
        bst.insertNode(node7);
        bst.insertNode(node8);
        bst.insertNode(node9);

        System.out.println(bst.lowestCommonAncestor(node1,node3,node7));

    }
}
