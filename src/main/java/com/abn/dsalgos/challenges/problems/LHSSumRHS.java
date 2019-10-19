package com.abn.dsalgos.challenges.problems;


/*
Given, an array of size n. Find an element which divides the array in two sub-arrays with equal sum.


 */
public class LHSSumRHS {

    public static void main(String[] args) {

        int[] array = {-1,3,0,1,4,-3};

        LHSSumRHS lhsSumRHS = new LHSSumRHS();
        System.out.println(lhsSumRHS.findElement(array));
    }

    public int findElement(int[] array) {

        int rsum = 0;
        int lsum = 0;

        for(int i =1;i<array.length;i++) {
            rsum += array[i];
        }

        for(int i =0,j=1; j< array.length; i++,j++) {
            rsum = rsum - array[j];
            lsum = lsum + array[i];

            if(lsum == rsum) {
                return array[j];
            }
        }
        return -1;
    }
}
