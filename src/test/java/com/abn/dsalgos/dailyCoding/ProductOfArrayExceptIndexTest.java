package com.abn.dsalgos.dailyCoding;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductOfArrayExceptIndexTest {

    ProductOfArrayExceptIndex productOfArrayExceptIndex;

    @BeforeClass
    public void before() throws Exception {
        productOfArrayExceptIndex = new ProductOfArrayExceptIndex();
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}},
                {new int[]{1, 2}, new int[]{2, 1}},
                {new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}},
                {new int[]{1, 0, 2, 5}, new int[]{0, 10, 0, 0}}
        };
    }

    @Test(dataProvider = "data")
    public void test1(int[] input, int[] expected) throws Exception {
        Assert.assertEquals(productOfArrayExceptIndex.productArray(input), expected);
    }
}
