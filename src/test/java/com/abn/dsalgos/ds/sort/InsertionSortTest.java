package com.abn.dsalgos.ds.sort;

import com.abn.dsalgos.sortAlgos.InsertionSort;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InsertionSortTest {

    InsertionSort sort;

    @BeforeMethod
    public void before() throws Exception {
        sort = new InsertionSort();
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                {new int[]{5,1,3,8,4,9,2}, new int[]{1,2,3,4,5,8,9}},
                {new int[]{8,0,2,1}, new int[]{0,1,2,8}}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] actual, int[] expected) throws Exception {
        Assert.assertEquals(sort.insertionSort(actual), expected);
    }
}
