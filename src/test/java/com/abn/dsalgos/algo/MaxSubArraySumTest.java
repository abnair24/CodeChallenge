package com.abn.dsalgos.algo;

import  org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MaxSubArraySumTest {
    MaxSubArraySum maxSubArraySum;

    @BeforeMethod
    public void before() throws Exception {
        maxSubArraySum = new MaxSubArraySum();
    }

    @Test
    public void test1() throws Exception {
        int[] t1 = new int[] {-1,4,3,-1};
        maxSubArraySum = new MaxSubArraySum();
        Assert.assertEquals(maxSubArraySum.maxSum(t1),7);
    }

    @Test
    public void test2() throws Exception {
        int[] t1 = new int[] {7,-1,4,8,-2,-6};
        maxSubArraySum = new MaxSubArraySum();
        Assert.assertEquals(maxSubArraySum.maxSum(t1),18);
    }
    @Test
    public void test3() throws Exception {
        int[] t1 = new int[] {-5,4,6,2,0,-4,3};
        maxSubArraySum = new MaxSubArraySum();
        Assert.assertEquals(maxSubArraySum.maxSum(t1),12);
    }

    @Test
    public void test4() throws Exception {
        int[] t1 = new int[] {3, 2, 1, 5, 10};
        maxSubArraySum = new MaxSubArraySum();
        Assert.assertEquals(maxSubArraySum.maxSum(t1),21);
    }

    @Test
    public void test5() throws Exception {
        int[] t1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArraySum = new MaxSubArraySum();
        Assert.assertEquals(maxSubArraySum.maxSum(t1),6);
    }
}
