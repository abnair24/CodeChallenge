package com.abn.dsalgos.challenges.string;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RepeatedStringTest {

    RepeatedString string = new RepeatedString();

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(string.repeatedCount("aba",10),7);
    }

    @Test
    public void singleCharTest() throws Exception {
        Assert.assertEquals(string.repeatedCount("x",970770),0);
    }

    @Test
    public void test2() throws Exception {
        Assert.assertEquals(string.repeatedCount("abxcabxca",2),1);
    }
}
