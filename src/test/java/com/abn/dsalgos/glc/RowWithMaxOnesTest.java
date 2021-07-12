package com.abn.dsalgos.glc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class RowWithMaxOnesTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        int[][] matrix = { {1, 1, 1, 1, 1}, {0, 1, 1, 1, 1}, {0, 0, 0, 1, 1}, {0, 0, 1, 1, 1} };
        int[][] matrix1 = { {0, 0, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 1, 1, 1, 1}, {0, 0, 1, 1, 1} };
        int[][] matrix2 = { {0, 1, 1}, {1, 1, 1} };
        int[][] matrix3 = { {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] matrix4 = { {0, 0, 0}, {0, 0, 0}, {0, 0, 1}};

        List<Object[]> list = Lists.newLinkedList();
        list.add(new Object[] {matrix, 0});
        list.add(new Object[] {matrix1, 2});
        list.add(new Object[] {matrix2, 1});
        list.add(new Object[] {matrix3, -1});
        list.add(new Object[] {matrix4, 2});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[][] matrix, int expected) {

        RowWithMaxOnes max = new RowWithMaxOnes();

        Assert.assertEquals(max.rowWithMax(matrix), expected);
    }
}
