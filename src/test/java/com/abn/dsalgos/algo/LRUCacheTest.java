package com.abn.dsalgos.algo;

import com.abn.design.LRUCache;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LRUCacheTest {

    LRUCache cache;

    @Test
    public void test() throws Exception {
        cache = new LRUCache(4);
        cache.putNode(1,1);
        cache.putNode(3,9);
        cache.putNode(2,4);
        cache.putNode(5,25);
        cache.putNode(4,16);

        Assert.assertEquals(cache.getNode(1),-1);
        Assert.assertEquals(cache.getNode(2), 4);

        cache.putNode(1, 1);
        Assert.assertEquals(cache.getNode(1), 1);
        Assert.assertEquals(cache.getNode(3), -1);
    }

    @Test
    public void test1() throws Exception {
        cache = new LRUCache(3);
        cache.putNode(2,2);
        cache.putNode(1,1);
        Assert.assertEquals(cache.getNode(2), 2);
        Assert.assertEquals(cache.getNode(1), 1);
        Assert.assertEquals(cache.getNode(2), 2);
        cache.putNode(3,3);
        cache.putNode(4,4);
        Assert.assertEquals(cache.getNode(3), 3);
        Assert.assertEquals(cache.getNode(2), 2);
        Assert.assertEquals(cache.getNode(1), -1);
        Assert.assertEquals(cache.getNode(4), 4);

    }
}
