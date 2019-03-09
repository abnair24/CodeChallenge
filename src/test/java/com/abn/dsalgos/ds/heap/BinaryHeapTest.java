package com.abn.dsalgos.ds.heap;

import org.testng.annotations.Test;

public class BinaryHeapTest {

    @Test
    public void test1() throws Exception {
        int[] array = {3,2,1,15,5,4,45};

        BinaryHeap binaryHeap = new BinaryHeap(array.length);
        binaryHeap.createHeap(array);

        System.out.println(binaryHeap.extract());

        binaryHeap = new BinaryHeap(array.length,false);
        binaryHeap.createHeap(array);

        System.out.println(binaryHeap.extract());
    }


}
