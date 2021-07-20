package com.abn.dsalgos.algo.dp;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class HouseRobberTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {new int[] {0, 0, 0, 0}, 0});
        list.add(new Object[] {new int[] {1, 2, 3, 1}, 4});
        list.add(new Object[] {new int[] {2, 5, 1, 3, 6, 2, 4}, 15});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[] input, int expected) {
        HouseRobber houseRobber = new HouseRobber();
        Assert.assertEquals(houseRobber.robMax(input), expected);
    }
}
