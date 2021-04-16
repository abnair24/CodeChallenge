package com.abn.dsalgos.algo.twoPointer;

import com.abn.dsalgos.algo.twoPointers.SquaredSortedArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class SquareSortedArrayTest {

    SquaredSortedArray square ;

    @DataProvider
    public Iterator<Object[]> dp() {
        List lst = Lists.newLinkedList();
        lst.add(new Object[] {new int[] {-7,-3,2,3,11}, new int[] {4,9,9,49,121}});
        lst.add(new Object[] {new int[] {-1}, new int[]{1}});
        lst.add(new Object[] {new int[] {-5,-3,-2,-1}, new int[]{1, 4, 9, 25}});
        lst.add(new Object[] {new int[] {-3, -1, 0, 1, 2}, new int[]{0, 1, 1, 4, 9}});
        lst.add(new Object[] {new int[] {-2, -1, 0, 2, 3}, new int[]{0, 1, 4, 4, 9}});

        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[] array, int[] expected) {
        square = new SquaredSortedArray();
        Assert.assertEquals(square.squares(array), expected);
    }
}
