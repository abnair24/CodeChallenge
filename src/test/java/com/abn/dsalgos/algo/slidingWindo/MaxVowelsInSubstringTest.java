package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class MaxVowelsInSubstringTest {

    MaxVowelsInSubstring max;

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> lst = Lists.newLinkedList();

        lst.add(new Object[] {"ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33, 7});
        lst.add(new Object[] {"abciiidef", 3, 3});
        lst.add(new Object[] {"aeiou", 2, 2});

        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(String str, int k, int expected) throws Exception {
        max = new MaxVowelsInSubstring();

        Assert.assertEquals(max.maxVowels(str, k), expected);
    }
}
