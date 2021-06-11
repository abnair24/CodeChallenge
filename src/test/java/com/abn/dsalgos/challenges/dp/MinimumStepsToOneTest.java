package com.abn.dsalgos.challenges.dp;

import org.testng.annotations.Test;

public class MinimumStepsToOneTest {


    @Test
    public void test() throws Exception {
        MinimumStepsToOne min = new MinimumStepsToOne(50);
        System.out.println(min.minSteps(50));
    }
}
