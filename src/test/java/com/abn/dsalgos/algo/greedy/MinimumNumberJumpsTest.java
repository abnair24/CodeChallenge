package com.abn.dsalgos.algo.greedy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MinimumNumberJumpsTest {

    @Test
    public void test() {
        MinimumNumberJumps minimumNumberJumps = new MinimumNumberJumps();
        Assert.assertEquals(minimumNumberJumps.jumps("....x..xx...x.."), 5);
        Assert.assertEquals(minimumNumberJumps.jumps("............x.x"), 1);
    }
}
