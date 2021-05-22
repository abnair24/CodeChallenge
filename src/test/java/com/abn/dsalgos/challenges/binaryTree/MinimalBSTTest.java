package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class MinimalBSTTest {

    private final MinimalBST minimalBST = new MinimalBST();


    @Test
    public void createBST() {
        int [] array = new int[] {1,2,3,4,5,6,7,8};
        MyTreeNode<Integer> root = minimalBST.arrayToBST(array);
        minimalBST.preOrder(root);
    }
}
