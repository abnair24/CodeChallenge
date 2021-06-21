package com.abn.dsalgos.challenges.sort;

import com.abn.dsalgos.algo.binarySearch.SearchInRotatedArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchInRotatedArrayTest {

    private SearchInRotatedArray searchInRotatedArray;

    @BeforeMethod
    public void before() throws Exception {
        searchInRotatedArray = new SearchInRotatedArray();
    }
    @Test
    public void test() throws Exception
    {
        int[] array = new int[] {4,5,6,7,0,1,2};
        Assert.assertEquals(searchInRotatedArray.search(array,0,array.length-1,0),4);
    }

    @Test
    public void test1() throws Exception {
        int[] array = new int[]{11,20,23,4,5,6,7,8,9};
        Assert.assertEquals(searchInRotatedArray.search(array,0,array.length-1,4),3);
    }


}
