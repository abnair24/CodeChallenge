package com.abn.dsalgos.leetcode30Day;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BackSpaceStringCompareTest {

    BackSpaceStringCompare backSpaceStringCompare;

    @BeforeMethod
    public void before() throws Exception {
        backSpaceStringCompare = new BackSpaceStringCompare();
    }


    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                {"ab#c","ad#c",true},
                {"ab##","c#d#",true},
                {"a##c","#a#c",true},
                {"a#c","b",false}
        };
    }

    @Test(dataProvider = "data")
    public void test1(String first, String second, boolean status) throws Exception {
        Assert.assertEquals(backSpaceStringCompare.isBackSpaceCompareSame(first, second),status);
    }
}
