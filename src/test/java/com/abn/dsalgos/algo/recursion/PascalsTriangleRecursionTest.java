package com.abn.dsalgos.algo.recursion;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import org.testng.internal.collections.Ints;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PascalsTriangleRecursionTest {

    PascalsTriangleRecursion pascalsTriangleRecursion = new PascalsTriangleRecursion();

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {5, Stream.of(Ints.asList(1),
                Ints.asList(1, 1),
                Ints.asList(1, 2, 1),
                Ints.asList(1, 3, 3, 1),
                Ints.asList(1, 4, 6, 4, 1))
                .collect(Collectors.toList())});

        list.add(new Object[] {2, Stream.of(Ints.asList(1),
                Ints.asList(1, 1))
                .collect(Collectors.toList())});

        list.add(new Object[] {1, Stream.of(Ints.asList(1))
                .collect(Collectors.toList())});

        list.add(new Object[] {7, Stream.of(Ints.asList(1),
                Ints.asList(1, 1),
                Ints.asList(1, 2, 1),
                Ints.asList(1, 3, 3, 1),
                Ints.asList(1, 4, 6, 4, 1),
                Ints.asList(1, 5, 10, 10, 5, 1),
                Ints.asList(1, 6, 15, 20, 15, 6, 1))
                .collect(Collectors.toList())});

        return list.iterator();
    }

    @Test (dataProvider = "dp")
    public void test(int rows, List<List<Integer>> expected) {
        Assert.assertEquals(pascalsTriangleRecursion.generatePascalTriangle(rows), expected);
    }
}
