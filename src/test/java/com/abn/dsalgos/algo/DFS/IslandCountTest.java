package com.abn.dsalgos.algo.DFS;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class IslandCountTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        int[][] matrix1 =
                {
                        {1, 1, 1, 1, 0},
                        {1, 1, 0, 1, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0}
                };

        int[][] matrix2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {matrix1, 1});
        list.add(new Object[] {matrix2, 3});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[][] input, int expected) {

        IslandCount islandCount = new IslandCount();
        Assert.assertEquals(islandCount.getIslandCount(input), expected);
    }
}
