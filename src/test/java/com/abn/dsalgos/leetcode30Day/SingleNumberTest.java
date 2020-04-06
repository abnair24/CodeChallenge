package com.abn.dsalgos.leetcode30Day;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingleNumberTest {

    private SingleNumber singleNumber;
    int [] array;

    @BeforeMethod
    public void before() throws Exception {
        singleNumber = new SingleNumber();
    }

    @Test
    public void test() throws Exception {
        array = new int[]{1, 2, 4, 6, 2, 1, 6};
        Assert.assertEquals(singleNumber.singleNumberInArray(array),4);
    }

    @Test
    public void test1() throws Exception {
        array = new int[] {1,2,1};
        Assert.assertEquals(singleNumber.singleNumberInArray((array)),2);
    }

    @Test
    public void test2() throws Exception {
        array = new int[] {1,1,1} ;
        Assert.assertEquals(singleNumber.singleNumberInArray(array),0);
    }

    @Test
    public void test3() throws Exception {
        array = new int[] {2} ;
        Assert.assertEquals(singleNumber.singleNumberInArray(array),2);
    }
}
