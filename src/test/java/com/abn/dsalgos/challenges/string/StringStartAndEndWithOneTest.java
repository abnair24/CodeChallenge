package com.abn.dsalgos.challenges.string;

import com.abn.dsalgos.challenges.string.StringStartAndEndWithOne;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringStartAndEndWithOneTest {

    @Test
    public void test1() throws Exception {
        StringStartAndEndWithOne b = new StringStartAndEndWithOne();
        Assert.assertEquals(b.getCount("0110"),1);
    }

    @Test
    public void test2() throws Exception {
        StringStartAndEndWithOne b = new StringStartAndEndWithOne();
        Assert.assertEquals(b.getCount("001001101"),6);
    }

    @Test
    public void test3() throws Exception {
        StringStartAndEndWithOne b = new StringStartAndEndWithOne();
        Assert.assertEquals(b.getCount("1001101010001"),15);
    }

    @Test
    public void test4() throws Exception {
        StringStartAndEndWithOne b = new StringStartAndEndWithOne();
        Assert.assertEquals(b.getCount("01000"),0);
    }

    @Test
    public void test5() throws Exception {
        StringStartAndEndWithOne b = new StringStartAndEndWithOne();
        Assert.assertEquals(b.getCount("00000"),0);
    }
}
