package com.abn.dsalgos.algo;

import com.abn.design.LFUCache;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LFUCacheTest {

    LFUCache cache ;

    @Test
    public void test() throws Exception {
        cache = new LFUCache(2);

        cache.putKey(1, 1);
        cache.putKey(2, 2);
        Assert.assertEquals(cache.getKey(1), 1);
        cache.putKey(3, 3);
        Assert.assertEquals(cache.getKey(2), -1);
        Assert.assertEquals(cache.getKey(3), 3);
        cache.getKey(3);
        cache.putKey(4, 4);
        Assert.assertEquals(cache.getKey(1), -1);
        Assert.assertEquals(cache.getKey(3), 3);
        Assert.assertEquals(cache.getKey(4), 4);
    }

    @Test
    public void test2() throws Exception {
        cache = new LFUCache(0);
        cache.putKey(0, 0);
        cache.getKey(0);
    }
}
