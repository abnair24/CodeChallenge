package com.abn.dsalgos.challenges.heap;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class KthSmallestINArrayTest {

    @Test
    public void test() throws Exception {
        KthSmallestInArray small = new KthSmallestInArray();

        List<Integer> array = Arrays.asList(7,4,6,3,2,9,1,8,5);

        Assert.assertEquals(small.findKthSmallest(array,1),1);
        Assert.assertEquals(small.findKthSmallest(array,4),4);
    }
}
