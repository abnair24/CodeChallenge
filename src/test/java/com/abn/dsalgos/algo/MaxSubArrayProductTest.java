package com.abn.dsalgos.algo;

import org.testng.annotations.Test;

public class MaxSubArrayProductTest {

    MaxSubArrayProduct max = new MaxSubArrayProduct();

    @Test
    public void test1() throws Exception {
        long[] a = new long[] {1, 2, -2, -3, 3, 5};
        System.out.println(max.maxProduct(a));
    }

    @Test
    public void test2() throws Exception {
        long[] a = new long[] {-4, -2, 10, 20, -3};
        System.out.println(max.maxProduct(a));
    }

    @Test
    public void test3() throws Exception {
        long[] a = new long[] {1000000000, -1000000000};
        System.out.println(max.maxProduct(a));
    }
}
