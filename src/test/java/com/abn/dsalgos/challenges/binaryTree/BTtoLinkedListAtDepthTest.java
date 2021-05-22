package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BTtoLinkedListAtDepthTest {

    BTtoLinkedListAtDepth bTtoLinkedListAtDepth = new BTtoLinkedListAtDepth();


    @Test
    public void test() throws Exception {
        bTtoLinkedListAtDepth.root = new MyTreeNode<>(1);
        bTtoLinkedListAtDepth.root.left = new MyTreeNode<>(2);
        bTtoLinkedListAtDepth.root.right = new MyTreeNode<>(3);
        bTtoLinkedListAtDepth.root.left.left = new MyTreeNode<>(4);
        bTtoLinkedListAtDepth.root.left.right = new MyTreeNode<>(5);
        bTtoLinkedListAtDepth.root.right.left = new MyTreeNode<>(6);
        bTtoLinkedListAtDepth.root.right.right = new MyTreeNode<>(7);

        bTtoLinkedListAtDepth.linkedListAtDept(bTtoLinkedListAtDepth.root);
    }

    @Test
    public void test1() throws Exception {
        bTtoLinkedListAtDepth.root = new MyTreeNode<>(1);
        bTtoLinkedListAtDepth.root.left = new MyTreeNode<>(2);
        bTtoLinkedListAtDepth.root.right = new MyTreeNode<>(3);
        bTtoLinkedListAtDepth.root.left.left = new MyTreeNode<>(4);
        bTtoLinkedListAtDepth.root.left.right = new MyTreeNode<>(5);
        bTtoLinkedListAtDepth.root.right.left = new MyTreeNode<>(6);
        bTtoLinkedListAtDepth.root.right.right = new MyTreeNode<>(7);
        bTtoLinkedListAtDepth.root.right.right.left = new MyTreeNode<>(8);
        bTtoLinkedListAtDepth.root.right.right.right = new MyTreeNode<>(9);

        bTtoLinkedListAtDepth.binaryTreeLinkedList(bTtoLinkedListAtDepth.root);

    }
}
