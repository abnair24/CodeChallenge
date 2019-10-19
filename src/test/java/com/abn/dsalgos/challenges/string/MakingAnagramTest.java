package com.abn.dsalgos.challenges.string;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MakingAnagramTest {

    MakingAnagram string =new MakingAnagram();

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(string.makeAnagram("fcrxzwscanmligyxyvym","jxwtrhvujlmrpdoqbisbwhmgpmeoke"),30);
    }

    @Test
    public void test2() throws Exception {
        Assert.assertEquals(string.makeAnagram("abc","abcdef"),3);
    }

    @Test
    public void test3() throws Exception {
        Assert.assertEquals(string.makeAnagram("a","a"),0);
    }

    @Test
    public void test4() throws Exception {
        Assert.assertEquals(string.makeAnagram("abc","abccef"),3);
    }

    @Test
    public void test5() throws Exception {
        Assert.assertEquals(string.makeAnagram("abc","def"),6);
    }

    @Test
    public void test6() throws Exception {
        Assert.assertEquals(string.makeAnagram("abc","aed"),4);
    }
}
