package com.abn.dsalgos.dailyCoding;

import org.testng.annotations.Test;

public class SumOfListisKTest {

    @Test
    public void test1() throws Exception {
        SumOfLiskisK sumOfLiskisK = new SumOfLiskisK();
        int[] array = new int[] {10,12,14,2,5,4,6,8,1};
        sumOfLiskisK.sumOfListIsK(array,18);
    }
}
