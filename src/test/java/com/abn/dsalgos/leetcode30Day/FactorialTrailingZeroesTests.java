package com.abn.dsalgos.leetcode30Day;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTrailingZeroesTests {

    FactorialTrailingZeroes factorialTrailingZeroes;

    @BeforeMethod
    public void before() throws Exception {
        factorialTrailingZeroes = new FactorialTrailingZeroes();
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {4, 0},
                {5, 1},
                {9, 1},
                {10, 2},
                {14, 2},
                {21, 4},
                {25, 6},
                {29, 6},
                {32, 7},
                {625, 156},
                {660, 164}
        };
    }

    @Test(dataProvider = "data")
    public void test(int input, int expected) throws Exception {
        Assert.assertEquals(factorialTrailingZeroes.trailingZeroes(input), expected);
    }

}
