package com.abn.dsalgos.algo.twoPointer;

import com.abn.dsalgos.algo.twoPointers.PairWithTargetSum;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class PairWithTargetSumTest {

    PairWithTargetSum pair;

    @DataProvider
    public Iterator<Object[]> dp() {

        List lst = Lists.newLinkedList();
        lst.add(new Object[] { new int[]{1, 2, 3, 4, 6}, 6, new int[]{1, 3}});
        lst.add(new Object[] { new int[]{2, 5, 9, 11}, 11, new int[]{0, 2}});

        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[] array, int sum, int[] expected) throws Exception {

        pair = new PairWithTargetSum();
        Assert.assertEquals(pair.search(array, sum), expected);
    }
}
