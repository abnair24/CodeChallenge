package com.abn.dsalgos.challenges.problems;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class NextPermutationTest {


    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {new int[] {1, 2, 3}, new int[] {1, 3, 2}});
        list.add(new Object[] {new int[] {3, 2, 1}, new int[] {1, 2, 3}});
        list.add(new Object[] {new int[] {1, 4, 7, 6, 5, 3, 2, 1}, new int[] {1, 5, 1, 2, 3, 4, 6, 7}});
        list.add(new Object[] {new int[] {1, 1, 5}, new int[] {1, 5, 1}});

        return list.iterator();
    }

    @Test (dataProvider = "dp")
    public void nextPermute1(int[] input, int[] expected) {

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(input);
        Assert.assertEquals(input, expected);
    }
}
