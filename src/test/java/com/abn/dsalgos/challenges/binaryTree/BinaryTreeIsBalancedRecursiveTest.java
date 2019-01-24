package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BinaryTreeIsBalancedRecursiveTest {

    BinaryTreeIsBalancedRecursive<Integer> binaryTreeIsBalancedRecursive = new BinaryTreeIsBalancedRecursive<>();

    @Test
    public void test1() throws Exception {
        binaryTreeIsBalancedRecursive.root = new MyTreeNode<>(1);
        binaryTreeIsBalancedRecursive.root.left = new MyTreeNode(2);
        binaryTreeIsBalancedRecursive.root.right = new MyTreeNode(3);
        binaryTreeIsBalancedRecursive.root.left.left = new MyTreeNode(4);
        binaryTreeIsBalancedRecursive.root.left.right = new MyTreeNode(5);
        binaryTreeIsBalancedRecursive.root.right.right = new MyTreeNode(6);
        binaryTreeIsBalancedRecursive.root.right.right.right = new MyTreeNode(7);

        System.out.println(binaryTreeIsBalancedRecursive.isBalanced(binaryTreeIsBalancedRecursive.root));
    }
}
