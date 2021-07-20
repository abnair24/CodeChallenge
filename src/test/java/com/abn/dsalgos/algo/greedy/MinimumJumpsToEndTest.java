package com.abn.dsalgos.algo.greedy;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class MinimumJumpsToEndTest {

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {new int[] {1, 1, 3, 6, 9, 3, 0, 1, 3}, 4});
        list.add(new Object[] {new int[] {9, 9, 2, 1, 3, 4}, 1});
        list.add(new Object[] {new int[] {1, 2, 3}, 2});
        list.add(new Object[] {new int[] {1, 2}, 1});
        list.add(new Object[] {new int[] {0, 2}, 0});
        list.add(new Object[] {new int[] {1}, 0});
        list.add(new Object[] {new int[] {1, 1, 1, 1}, 3});
        list.add(new Object[] {new int[] {2, 3, 1, 1, 4}, 2});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[] array, int expected) {
        MinimumJumpsToEnd minimumJumpsToEnd = new MinimumJumpsToEnd();
        Assert.assertEquals(minimumJumpsToEnd.minJumps(array), expected);
    }
}
