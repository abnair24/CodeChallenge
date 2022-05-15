package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubArrayProductLessThanKTest {

    @Test
    public void test() throws Exception {

        Assert.assertEquals(new SubArrayProductLessThanK().subArrayProduct(new int[] {10,5,2,6}, 100), 8);
    }
}
