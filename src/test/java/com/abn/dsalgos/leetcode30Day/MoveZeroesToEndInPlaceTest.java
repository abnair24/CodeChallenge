package com.abn.dsalgos.leetcode30Day;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MoveZeroesToEndInPlaceTest {

    MoveZeroesToEndInPlace moveZeroesToEndInPlace;

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}},
//                {new int[]{1, 0}, new int[]{1, 0}},
//                {new int[]{0, 1}, new int[]{1, 0}},
//                {new int[]{0, 0}, new int[]{0, 0}}
        };
    }

    @BeforeMethod
    public void before() throws Exception {
        moveZeroesToEndInPlace = new MoveZeroesToEndInPlace();
    }

    @Test(dataProvider = "data")
    public void test1(int[] inputArray, int[] resultArray) throws Exception {
        Assert.assertEquals(moveZeroesToEndInPlace.push(inputArray), resultArray);
    }
}
