package com.abn.dsalgos.challenges.string;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LongestSubstringTest {

    LongestSubstring str = new LongestSubstring();

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(str.longestSubstring("GEEKSFORGEEKS"), "EKSFORG");
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
    public void test4() throws Exception {
        Assert.assertEquals(str.longestSubstring("PWWKEW"),"WKE");

    }

    @Test
    public void test5() throws Exception {
        Assert.assertEquals(str.longestSubstring("BBBBE"),"BE");
    }


}
