package com.abn.dsalgos.ds.sort;

import com.abn.dsalgos.sortAlgos.HeapSort;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HeapSortTest {

    HeapSort heapsort;

    @BeforeMethod
    public void before() throws Exception {
        heapsort = new HeapSort();
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                {new int[]{12,11,13,5,6,7}, new int[]{5,6,7,11,12,13}},
                {new int[]{8,10,12,1}, new int[]{1,8,10,12}}
        };
    }

    @Test(dataProvider = "data")
    public void test( int[] actual, int[] expected) throws Exception {
        Assert.assertEquals(heapsort.sort(actual),expected);
    }
}

