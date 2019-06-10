package com.abn.dsalgos.algo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxProductOfAnySubArrayTest {

    @Test
    public void test1() throws Exception {
        MaxProductOfAnySubArray max = new MaxProductOfAnySubArray();
        long[] a = new long[] {-4, -2, 10, 20, -3};
        Assert.assertEquals(max.maximumSubsetProduct(a),2400);
    }

    @Test
    public void test2() throws Exception {
        MaxProductOfAnySubArray max = new MaxProductOfAnySubArray();
        long[] a = new long[] {1, 2, -2, -3, 3, 5};
        Assert.assertEquals(max.maximumSubsetProduct(a),180);
    }

    @Test
    public void test3() throws Exception {
        MaxProductOfAnySubArray max = new MaxProductOfAnySubArray();
        long[] a = new long[] {-10,10};
        Assert.assertEquals(max.maximumSubsetProduct(a),10);
    }

    @Test
    public void test4() throws Exception {
        MaxProductOfAnySubArray max = new MaxProductOfAnySubArray();
        long[] a = new long[] {1, -1, -1, 1};
        Assert.assertEquals(max.maximumSubsetProduct(a),1);
    }

    @Test
    public void test5() throws Exception {
        MaxProductOfAnySubArray max = new MaxProductOfAnySubArray();
        long[] a = new long[] { 3, 2, 1, 5, 10};
        Assert.assertEquals(max.maximumSubsetProduct(a),300);
    }


    @Test
    public void test6() throws Exception {
        MaxProductOfAnySubArray max = new MaxProductOfAnySubArray();
        long[] a = new long[] {-1};
        Assert.assertEquals(max.maximumSubsetProduct(a),-1);
    }
}
