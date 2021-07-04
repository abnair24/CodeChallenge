package com.abn.dsalgos.leetcode30Day;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidParenthesisTest {

    ValidParenthesis validParenthesis;

    @BeforeClass
    public void before() throws Exception {
        validParenthesis = new ValidParenthesis();
    }

    @Test
    public void test() throws Exception {
        Assert.assertFalse(validParenthesis.checkValidString("(*))"));
    }
}
