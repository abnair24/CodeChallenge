package com.abn.dsalgos.challenges.string;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IsSubSequenceTest {

    @Test
    public void test1() throws Exception {
        IsSubSequence isSubSequence = new IsSubSequence();
        Assert.assertTrue(isSubSequence.isSubSequence("AXZ","AFXCWZ"));
    }

    @Test
    public void test2() throws Exception {
        IsSubSequence isSubSequence = new IsSubSequence();
        Assert.assertFalse(isSubSequence.isSubSequence("AZ","AXQ"));
    }

    @Test
    public void test3() throws Exception {
        IsSubSequence isSubSequence = new IsSubSequence();
        Assert.assertTrue(isSubSequence.isSubSequence("YL","ELNCYCLOPEDIA"));
    }
}
