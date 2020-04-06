package com.abn.dsalgos.algo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FactorialTrailingZerosTest {

    FactorialTrailingZeros f;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        f = new FactorialTrailingZeros();
    }

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(f.trailingZeros(5),1);
    }

    @Test
    public void test2() throws Exception {
        Assert.assertEquals(f.trailingZeros(0),0);
    }

    @Test
    public void test3() throws Exception {
        Assert.assertEquals(f.trailingZeros(10),2);
    }
}
