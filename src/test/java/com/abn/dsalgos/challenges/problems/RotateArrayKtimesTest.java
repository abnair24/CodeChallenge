package com.abn.dsalgos.challenges.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RotateArrayKtimesTest {


    @Test
    public void rotateByLengthTimesTest() {
        int[] array = new int[] {1,2,3,4,5,6,7};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();

        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,7, true),array);
    }

    @Test
    public void rotateByLengthMultiplierTimesTest() {
        int[] array = new int[] {1,2,3,4,5,6,7};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,49, true),array);
    }

    @Test
    public void rotateByLessThanLengthTimesTest() {
        int[] array = new int[] {1,2,3,4,5,6,7};
        int[] expectedArray = new int[] {4,5,6,7,1,2,3};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,3, true),expectedArray);
    }

    @Test
    public void rotateByGreaterThanLengthTimesTest() {
        int[] array = new int[] {1,2,3,4,5,6,7};
        int[] expectedArray = new int[] {6,7,1,2,3,4,5};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,12, true),expectedArray);
    }

    @Test
    public void rotateEmptyArrayTest() {
        int[] array = new int[] {};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,12, true),array);
    }

    @Test
    public void rotateArrayOfSizeOne() {
        int[] array = new int[] {1};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array, 2, true),array);
    }


    @Test
    public void rotateByLengthTimesRightTest() {
        int[] array = new int[] {1,2,3,4,5,6,7};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();

        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,7, false),array);
    }

    @Test
    public void rotateByLengthMultiplierTimesRightTest() {
        int[] array = new int[] {1,2,3,4,5,6,7};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,49, false),array);
    }

    @Test
    public void rotateByLessThanLengthTimesRightTest() {
        int[] array = new int[] {1,2,3,4,5,6,7};
        int[] expectedArray = new int[] {5,6,7,1,2,3,4};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,3, false),expectedArray);
    }

    @Test
    public void rotateByGreaterThanLengthTimesRightTest() {
        int[] array = new int[] {1,2,3,4,5,6,7};
        int[] expectedArray = new int[] {3,4,5,6,7,1,2};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,12, false),expectedArray);
    }

    @Test
    public void rotateEmptyArrayRightTest() {
        int[] array = new int[] {};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array,12, false),array);
    }

    @Test
    public void rotateArrayOfSizeOneRightTest() {
        int[] array = new int[] {1};
        RotateArrayKtimes rotateArrayKtimes = new RotateArrayKtimes();
        Assert.assertEquals(rotateArrayKtimes.rotateArray(array, 2, false),array);
    }
}
