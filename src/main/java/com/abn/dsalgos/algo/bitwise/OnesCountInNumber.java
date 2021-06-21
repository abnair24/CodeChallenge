package com.abn.dsalgos.algo.bitwise;

public class OnesCountInNumber {

    public int countOnes(int num) {
        int count = 0;
        while(num > 0) {

            // num & num - 1 sets off each one in the iteration leaving num as 0 at the end.
            num = num & (num -1);
            count ++;
        }

        return count;
    }
}
