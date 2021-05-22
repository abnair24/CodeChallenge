package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyBSTNode;
import org.testng.annotations.Test;

public class BinaryTreeIsBSTTest {

    BinaryTreeIsBST<Integer> binaryTreeIsBST = new BinaryTreeIsBST<>();

    @Test
    public void test() throws Exception {
        binaryTreeIsBST.root = new MyBSTNode<>(15);
        binaryTreeIsBST.root.left = new MyBSTNode<>(10);
        binaryTreeIsBST.root.right = new MyBSTNode<>(20);
        binaryTreeIsBST.root.left.left = new MyBSTNode<>(5);
        binaryTreeIsBST.root.left.left.left = new MyBSTNode<>(1);
        binaryTreeIsBST.root.left.left.right = new MyBSTNode<>(7);
        binaryTreeIsBST.root.left.left.right.right = new MyBSTNode<>(8);
        binaryTreeIsBST.root.right.left = new MyBSTNode<>(17);
        binaryTreeIsBST.root.right.right = new MyBSTNode<>(25 );

        System.out.println(binaryTreeIsBST.isBST(binaryTreeIsBST.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }

    @Test
    public void test1() throws Exception {
        binaryTreeIsBST.root = new MyBSTNode<>(30);
        binaryTreeIsBST.root.left = new MyBSTNode<>(5);
        binaryTreeIsBST.root.right = new MyBSTNode<>(40);
        binaryTreeIsBST.root.right.left = new MyBSTNode<>(10);
        binaryTreeIsBST.root.right.right = new MyBSTNode<>(50 );

        System.out.println(binaryTreeIsBST.isBST(binaryTreeIsBST.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }


}
