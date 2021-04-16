package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringPermutationsIndexListTest {

    StringPermutationsIndexList stringPerm;

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> lst = Lists.newLinkedList();

        lst.add(new Object[] {"ppqp", "pq", Lists.newArrayList(1, 2)});
        lst.add(new Object[] {"abbcabc", "abc", Lists.newArrayList(2, 3, 4)});
        lst.add(new Object[] {"cbaebabacd", "abc", Lists.newArrayList(0, 6)});
        lst.add(new Object[] {"abab", "ab", Lists.newArrayList(0, 1, 2)});

        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(String str, String pattern, ArrayList<Integer> array) throws Exception {
        stringPerm = new StringPermutationsIndexList();
        Assert.assertEquals(stringPerm.findStringAnagrams(str, pattern), array);
    }
}
