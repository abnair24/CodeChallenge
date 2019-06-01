package com.abn.dsalgos.algo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxSubArraySumTest {

    @Test
    public void test1() throws Exception {
        int[] t1 = new int[] {-1,4,3,-1};
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        Assert.assertEquals(maxSubArraySum.maxSum(t1),7);
    }

    @Test
    public void test2() throws Exception {
        int[] t1 = new int[] {7,-1,4,8,-2,-6};
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        Assert.assertEquals(maxSubArraySum.maxSum(t1),18);
    }
    @Test
    public void test3() throws Exception {
        int[] t1 = new int[] {-5,4,6,2,0,-4,3};
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        Assert.assertEquals(maxSubArraySum.maxSum(t1),12);
    }

}
