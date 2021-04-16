package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LongestSubstringTest {

    LongestSubstring str = new LongestSubstring();

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(str.longestSubstring("GEKSFORGEEKS"), "KSFORGE");
    }

    @Test
    public void test2() throws Exception {
        Assert.assertEquals(str.longestSubstring("GEEKSFORGEEKSABCDH"),"EKSABCDH");
    }

    @Test
    public void test3() throws Exception {
        Assert.assertEquals(str.longestSubstring("BBBB"),"B");
    }

    @Test
    public void test6() throws Exception {
        Assert.assertEquals(str.longestSubstring("abbcdafebgh"), "cdafebgh");
    }

    @Test
    public void test5() throws Exception {
        Assert.assertEquals(str.longestSubstring("BBBBE"),"BE");
    }
}
