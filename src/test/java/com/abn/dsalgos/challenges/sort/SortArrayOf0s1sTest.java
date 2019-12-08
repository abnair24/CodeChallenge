package com.abn.dsalgos.challenges.sort;

import org.testng.annotations.Test;

public class SortArrayOf0s1sTest {

    private SortArrayOf0s1s sortTest = new SortArrayOf0s1s();

    @Test
    public void test() throws Exception {
        int[] array = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        sortTest.sort(array,array.length);
    }
}
