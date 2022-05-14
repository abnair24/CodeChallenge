package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxValueInWindowTest {


    MaxValueInWindow maxValueInWindow = new MaxValueInWindow();

    @Test
    public void test() {

        Assert.assertEquals(maxValueInWindow.maxSlidingWindow(new int[]{1, 2, 5, 1, 3, 4}, 3), 9);

    }
}
