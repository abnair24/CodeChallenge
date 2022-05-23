package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class MaximumScoreTest {

    MaximumScore maximumScore;

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> lst = Lists.newLinkedList();

        lst.add(new Object[] {new int[] {1,2,3,4,5,6,1}, 3, 12});
        lst.add(new Object[] {new int[] {2,2,2}, 2, 4});
        lst.add(new Object[] {new int[] {9,7,7,9,7,7,9}, 7, 55});
        lst.add(new Object[] {new int[] {1,79,80,1,1,1,200,1},3, 202});

        return lst.iterator();
    }

    @Test (dataProvider = "dp")
    public void test(int[] points, int k, int expected) throws Exception {

        Assert.assertEquals(new MaximumScore().maxScore(points, k), expected);
    }
}
