package com.abn.dsalgos.algo.greedy;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class MinimumPlatformsTest {

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {new int[] {900, 940, 950, 1100, 1500, 1800}, new int[] {950, 1030, 1120, 1130, 1900, 2000}, 3});
        list.add(new Object[] {new int[] {900, 940, 950, 1100, 1500, 1800}, new int[] {910, 1200, 1120, 1130, 1900, 2000}, 3});
        list.add(new Object[] {new int[] {900, 940, 950, 1100, 1500, 1800}, new int[] {910, 1040, 1120, 1130, 1900, 2000}, 2});

        return list.iterator();
    }

    @Test (dataProvider = "dp")
    public void test(int[] arrival, int[] dept, int expected) {
        MinimumPlatforms minimumPlatforms = new MinimumPlatforms();
        Assert.assertEquals(minimumPlatforms.minimum(arrival, dept), expected);
    }
}
