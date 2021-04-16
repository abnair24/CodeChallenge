package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class LongestOnesTest {

    LongestOnes longestOnes;

    @DataProvider
    public Iterator<Object[]> dp(){

        List<Object[]> lst = Lists.newLinkedList();

        lst.add(new Object[] {new int[] {0,0,0,0}, 2, 2 });
        lst.add(new Object[] {new int[] {0,0,0,0}, 4, 4 });
        lst.add(new Object[] {new int[] {0,0,0,0}, 4, 4 });
        lst.add(new Object[] {new int[] {0,0,1,1,1,0,0}, 0, 3});
        lst.add(new Object[] {new int[] {0,0,0,0}, 0, 0 });
        lst.add(new Object[] {new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2, 6});
        lst.add(new Object[] {new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3, 10});

        return lst.iterator();
    }

    @Test(dataProvider = "dp" )
    public void test(int[] array, int k, int expected) throws Exception {
        longestOnes = new LongestOnes();
        Assert.assertEquals(longestOnes.getLongestOnes(array, k), expected);
    }
}
