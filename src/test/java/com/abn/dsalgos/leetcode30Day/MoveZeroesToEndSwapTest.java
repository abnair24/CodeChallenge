package com.abn.dsalgos.leetcode30Day;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MoveZeroesToEndSwapTest {

    MoveZeroesToEndSwap moveZeroesToEndSwap;

    @BeforeMethod
    public void before() throws Exception {
        moveZeroesToEndSwap = new MoveZeroesToEndSwap();
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {new int[]{0, 1, 0, 3, 12}, new int[]{12, 1, 3, 0, 0}},
                {new int[]{0, 5, 6, 0, 0, 2, 4, 0}, new int[]{4, 5, 6, 2, 0, 0, 0, 0}},
                {new int[]{0, 1}, new int[]{1, 0}},
                {new int[]{1, 0, 1, 2 ,0, 0, 4}, new int[]{1, 4, 1, 2, 0, 0, 0}}
        };
    }

    @Test(dataProvider = "data")
    public void test1(int[] array, int[] result) throws Exception {
        Assert.assertEquals(moveZeroesToEndSwap.pushZeroesToEnd(array), result);
    }
}
