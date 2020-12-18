package com.abn.dsalgos.challenges.string;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConsecutiveCharactersTest {

    ConsecutiveCharacters cons;

    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                {"leetcode", 2},
                {"abbcccddddeeeeedcba", 5},
                {"triplepillooooow", 5},
                {"hooraaaaaaaaaaay", 11},
                {"tourist", 1}
        };
    }

    @Test(dataProvider = "data")
    public void test1(String input, int expected) throws Exception {
       cons = new ConsecutiveCharacters();
        Assert.assertEquals(cons.consecutiveCharacters(input), expected);
    }
}
