package com.abn.dsalgos.challenges.graph;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class MaxIslandAreaTest {

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> list = Lists.newLinkedList();

        int[][] input = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int[][] input2 = {{0, 0, 0, 1}, {1, 0, 0, 1}};

        list.add(new Object[] {input, 6});
        list.add(new Object[] {input2, 2});
        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[][] matrix, int expected) {
        MaxIslandArea maxIslandArea = new MaxIslandArea();
        Assert.assertEquals(maxIslandArea.maxAreaOfIsland(matrix), expected);
    }
}
