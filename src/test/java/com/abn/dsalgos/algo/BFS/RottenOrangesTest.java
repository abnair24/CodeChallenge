package com.abn.dsalgos.algo.BFS;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class RottenOrangesTest {

    RottenOranges rottenOranges;

    @BeforeClass
    public void before() {
        rottenOranges = new RottenOranges();
    }

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] { new int[][] {{2,1,1},{1,1,0}, {0,1,1}}, 4});
        list.add(new Object[] { new int[][] {{2,1,1},{0,1,1}, {1,0,1}}, -1});
        list.add(new Object[] { new int[][] {{1,2,1},{1,0,0}, {2,1,1},{1,0,1}}, 3});
        list.add(new Object[] { new int[][] {{2,1,1},{1,1,0}, {0,1,2}}, 2});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[][] input, int expected) {

        Assert.assertEquals(rottenOranges.rotten(input), expected);
    }
}
