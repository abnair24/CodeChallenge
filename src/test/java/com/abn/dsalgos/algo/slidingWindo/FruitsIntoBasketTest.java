package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class FruitsIntoBasketTest {

    FruitsIntoBasket fruits;

    @DataProvider
    public Iterator<Object[]> data() {
        List<Object[]> lst = Lists.newLinkedList();

//        lst.add(new Object[]{new char[] {'A', 'B', 'C', 'A', 'C'}, 3});
//        lst.add(new Object[]{new char[] {'A', 'B', 'C', 'B', 'B', 'C'}, 5});
        lst.add(new Object[]{new char[] {'A', 'A', 'A', 'B', 'C', 'B', 'B', 'C', 'A', 'A', 'D'}, 5});

        return lst.iterator();
    }

    @Test(dataProvider = "data")
    public void test(char[] arr, int expected) {
        fruits = new FruitsIntoBasket();
        Assert.assertEquals(fruits.maxFruitCount(arr), expected);
    }
}
