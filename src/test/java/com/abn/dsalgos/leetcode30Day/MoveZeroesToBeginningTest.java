package com.abn.dsalgos.leetcode30Day;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MoveZeroesToBeginningTest {

    MoveZeroesToBeginning moveZeroesToBeginning;

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0}, new int[]{0, 0, 0, 1, 10, 20, 59, 63, 88}},
                {new int[]{1, 0}, new int[]{0, 1}},
                {new int[]{0, 0}, new int[]{0, 0}},
                {new int[]{1, 0, 1}, new int[]{0, 1, 1}}
        };
    }

    @BeforeMethod
    public void before() throws Exception {
        moveZeroesToBeginning = new MoveZeroesToBeginning();
    }

    @Test(dataProvider = "data")
    public void test(int[] array, int[] expected) {
        Assert.assertEquals(moveZeroesToBeginning.moveZero(array), expected) ;
    }


}
