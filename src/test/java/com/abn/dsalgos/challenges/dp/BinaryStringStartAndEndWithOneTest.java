package com.abn.dsalgos.challenges.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryStringStartAndEndWithOneTest {

    @Test
    public void test1() throws Exception {
        BinaryStringStartAndEndWithOne b = new BinaryStringStartAndEndWithOne();
        Assert.assertEquals(b.getCount("0110"),1);
    }

    @Test
    public void test2() throws Exception {
        BinaryStringStartAndEndWithOne b = new BinaryStringStartAndEndWithOne();
        Assert.assertEquals(b.getCount("001001101"),6);
    }

    @Test
    public void test3() throws Exception {
        BinaryStringStartAndEndWithOne b = new BinaryStringStartAndEndWithOne();
        Assert.assertEquals(b.getCount("1001101010001"),15);
    }

    @Test
    public void test4() throws Exception {
        BinaryStringStartAndEndWithOne b = new BinaryStringStartAndEndWithOne();
        Assert.assertEquals(b.getCount("01000"),0);
    }

    @Test
    public void test5() throws Exception {
        BinaryStringStartAndEndWithOne b = new BinaryStringStartAndEndWithOne();
        Assert.assertEquals(b.getCount("00000"),0);
    }
}
