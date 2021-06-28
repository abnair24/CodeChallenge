package com.abn.dsalgos.algo.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CountOfSubsetSumTest {

    @Test
    public void test() {
        CountOfSubsetSum subsetSum = new CountOfSubsetSum();
        Assert.assertEquals(subsetSum.subsetSumCount(new int[] {7, 3, 2, 5, 8}, 14), 1);
    }
}
