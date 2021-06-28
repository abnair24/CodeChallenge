package com.abn.dsalgos.algo.dp;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class StaircaseProblemTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {4, 7});
        list.add(new Object[] {10, 274});
        list.add(new Object[] {1, 1});
        list.add(new Object[] {2, 2});
        list.add(new Object[] {3, 4});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int num, int expected) {

        StaircaseProblem staircaseProblem = new StaircaseProblem();
        Assert.assertEquals(staircaseProblem.uniqueWays(num), expected);
    }
}
