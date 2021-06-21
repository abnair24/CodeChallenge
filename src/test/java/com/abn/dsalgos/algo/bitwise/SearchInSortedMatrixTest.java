package com.abn.dsalgos.algo.bitwise;

import com.abn.dsalgos.algo.binarySearch.SearchInSortedMatrix;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class SearchInSortedMatrixTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 16, true});
        list.add(new Object[] {new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 33, false});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[][] input, int target, boolean expected) {
        SearchInSortedMatrix searchInSortedMatrix = new SearchInSortedMatrix();
        Assert.assertEquals(searchInSortedMatrix.search(input, target), expected);
    }
}
