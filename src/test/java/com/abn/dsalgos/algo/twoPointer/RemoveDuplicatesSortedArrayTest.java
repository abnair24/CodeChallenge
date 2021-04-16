package com.abn.dsalgos.algo.twoPointer;

import com.abn.dsalgos.algo.twoPointers.RemoveDuplicatesSortedArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class RemoveDuplicatesSortedArrayTest {

    RemoveDuplicatesSortedArray duplicates;

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> lst = Lists.newLinkedList();
        lst.add(new Object[] {new int[] {0,0,1,1,1,2,2,3,3,4}, 5});
        lst.add(new Object[] {new int[] {1,1,2}, 2});
        lst.add(new Object[] {new int[] {2, 3, 3, 3, 6, 9, 9}, 4});
        lst.add(new Object[] {new int[] {1, 1, 1, 1}, 1});
        lst.add(new Object[] {new int[] {1, 2}, 2});

        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[] array, int expected) {
        duplicates = new RemoveDuplicatesSortedArray();
        Assert.assertEquals(duplicates.removeDuplicates(array), expected);
    }
}
