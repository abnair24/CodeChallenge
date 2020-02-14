package com.abn.dsalgos.challenges.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RotateArrayKtimesTest {


    @Test
    public void rotateByLengthTimesTest() throws Exception {
        int[] array = new int[] {1,2,3,4,5,6,7};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();

        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,7),array);
    }

    @Test
    public void rotateByLengthMultiplierTimesTest() throws Exception {
        int[] array = new int[] {1,2,3,4,5,6,7};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,49),array);
    }

    @Test
    public void rotateByLessThanLengthTimesTest() throws Exception {
        int[] array = new int[] {1,2,3,4,5,6,7};
        int[] expectedArray = new int[] {4,5,6,7,1,2,3};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,3),expectedArray);
    }

    @Test
    public void rotateByGreaterThanLengthTimesTest() throws Exception {
        int[] array = new int[] {1,2,3,4,5,6,7};
        int[] expectedArray = new int[] {6,7,1,2,3,4,5};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,12),expectedArray);
    }

    @Test
    public void rotateEmptyArrayTest() throws Exception {
        int[] array = new int[] {};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,12),array);
    }

    @Test
    public void rotateArrayOfSizeOne() throws Exception {
        int[] array = new int[] {1};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array, 2),array);
    }

}
