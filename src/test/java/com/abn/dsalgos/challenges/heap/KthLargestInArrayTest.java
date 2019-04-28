package com.abn.dsalgos.challenges.heap;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class KthLargestInArrayTest {

    @Test
    public void test() throws Exception {
        KthLargestInArray large = new KthLargestInArray();

        List<Integer> array = Arrays.asList(7,4,6,3,2,9,1,8,5);

        Assert.assertEquals(large.findLargest(array,1),9);
        Assert.assertEquals(large.findLargest(array,6),4);
    }
}
