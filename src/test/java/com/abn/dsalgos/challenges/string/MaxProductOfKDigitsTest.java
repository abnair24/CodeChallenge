package com.abn.dsalgos.challenges.string;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.channels.AsynchronousServerSocketChannel;

public class MaxProductOfKDigitsTest {

    @Test
    public void test1() throws Exception {

        MaxProductOfKDigits maxProductOfKDigits = new MaxProductOfKDigits();
        Assert.assertEquals(maxProductOfKDigits.maxProduct("34532237812378699",4),3888);
    }

    @Test
    public void test2() throws Exception {
        MaxProductOfKDigits maxProductOfKDigits = new MaxProductOfKDigits();
        Assert.assertEquals(maxProductOfKDigits.maxProduct("9009",2),0);
    }

    @Test
    public void test3() throws Exception {
        MaxProductOfKDigits maxProductOfKDigits = new MaxProductOfKDigits();
        Assert.assertEquals(maxProductOfKDigits.maxProduct("1",1),1);
    }

    @Test
    public void test4() throws Exception {
        MaxProductOfKDigits maxProductOfKDigits = new MaxProductOfKDigits();
        Assert.assertEquals(maxProductOfKDigits.maxProduct("9003",1),9);
    }

    @Test
    public void test5() throws Exception {
        MaxProductOfKDigits maxProductOfKDigits = new MaxProductOfKDigits();
        Assert.assertEquals(maxProductOfKDigits.maxProduct("9003",5),-1);
    }
}
