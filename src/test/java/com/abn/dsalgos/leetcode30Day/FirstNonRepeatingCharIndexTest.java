package com.abn.dsalgos.leetcode30Day;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstNonRepeatingCharIndexTest {

    FirstNonRepeatingCharIndex firstNonRepeatingCharIndex;

    @BeforeMethod
    public void before() throws Exception {
        firstNonRepeatingCharIndex = new FirstNonRepeatingCharIndex();
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"leetcode", 0},
                {"lovelifeheaven", 1},
                {"indiaismycountry", 2},
                {"abc", 0},
                {"$$$$", -1},
                {"#", 0},
                {"", -1}
        };
    }

    @Test(dataProvider = "data")
    public void test(String input, int expected) throws Exception {
        Assert.assertEquals(firstNonRepeatingCharIndex.uniqCharIndex(input), expected);
    }
}
