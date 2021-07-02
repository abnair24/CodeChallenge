package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class LongestSubstringWithKDistinctCharTest {

    LongestSubstringWithKDistinctChar longest;

    @DataProvider
    public Iterator<Object[]> data() {
        List<Object[]> lst = Lists.newLinkedList();
        lst.add(new Object[] {"araaci", 2, 4});
        lst.add(new Object[] {"cbbebi", 3, 5});
        lst.add(new Object[] {"araaci", 1, 2});
        lst.add(new Object[] {"ccaabbb", 2, 5});

        return lst.iterator();
    }

    @Test (dataProvider = "data")
    public void test(String str, int k, int expected) throws Exception {
        longest = new LongestSubstringWithKDistinctChar();
        Assert.assertEquals(longest.longestSubstring(str, k), expected);
    }
}
