package com.abn.dsalgos.leetcode30Day;

import com.abn.dsalgos.leetcode30Day.toDo.ValidParenthesis;
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
        Assert.assertEquals(validParenthesis.checkValidString("(*))"),false);
    }
}
