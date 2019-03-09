package com.abn.dsalgos.ds.heap;

import org.testng.annotations.Test;

public class HeapMinTest {

    @Test
    public void test1() throws Exception {
        int[] array = {3,2,1,15,5,4,45};

        HeapMin heapMin = new HeapMin(array.length);
        heapMin.createHeap(array);

        System.out.println(heapMin.extractMin());
    }


}
