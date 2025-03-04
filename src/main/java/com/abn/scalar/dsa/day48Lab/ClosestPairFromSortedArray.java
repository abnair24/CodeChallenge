package com.abn.scalar.dsa.day48Lab;

public class ClosestPairFromSortedArray {

    public int[] solve(int[] A, int[] B, int C) {

        int startPtr = 0;
        int endPtr = B.length - 1;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        int[] indexes = new int[2];

        while(startPtr < A.length && endPtr >= 0) {
            int sum = A[startPtr] + B[endPtr];
            int absDiff = Math.abs(C - sum);

            if(absDiff == 0) {
                return new int[] {A[startPtr], B[endPtr]};
            }

            // or case sample: A ;[1] , B [2,4] , C =4. O/P: [1, 2]
            else if(absDiff < min || (absDiff == min && startPtr == indexes[0] && endPtr < indexes[1])) {

                min = absDiff;
                result[0] = A[startPtr];
                result[1] = B[endPtr];
                indexes[0] = startPtr;
                indexes[1] = endPtr;

            }

            if(sum < C) {
                startPtr ++;
            } else {
                endPtr --;
            }
        }
        return result;
    }
}
