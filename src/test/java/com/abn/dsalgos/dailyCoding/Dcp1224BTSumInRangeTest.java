package com.abn.dsalgos.dailyCoding;

import com.abn.dsalgos.utils.MyBSTNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dcp1224BTSumInRangeTest {

    @Test
    public void test1() throws Exception {

        Dcp1224BTSumInRange dcp1224BTSumInRange = new Dcp1224BTSumInRange();
        MyBSTNode<Integer> myBSTNode = new MyBSTNode<>(5);

        myBSTNode.left = new MyBSTNode<>(3);
        myBSTNode.right = new MyBSTNode<>(8);
        myBSTNode.left.left = new MyBSTNode<>(2);
        myBSTNode.left.right = new MyBSTNode<>(4);
        myBSTNode.right.left = new MyBSTNode<>(6);
        myBSTNode.right.right = new MyBSTNode<>(10);
        Assert.assertEquals(dcp1224BTSumInRange.sumInRange(myBSTNode, 4, 9), 23);
    }
}
