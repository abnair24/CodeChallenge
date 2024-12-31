package com.abn.scalar.dsa.day34;

/*
Every element occurs twice except for 1, find the unique element.
Note: Duplicate elements are adjacent to each other but the array is not sorted.

Array : {3, 3, 1, 1, 8, 8, 10, 10, 19, 6, 6, 2, 2, 4, 4}
Approach:

if mid is not equal to mid -1 or mid + 1 then its unique.

if mid is not unique, as long as unique element has not appeared in first half, firs occurance of mid - 1 will be even index and second at odd index.
in that case, move right

if mid is not unique, as long as unique element has  appeared in first half, then first index will become odd, second will be even. then move left

 */
public class DuplicateElement {

    public int solve(int[] array) {
        int high = array.length - 1;
        int low = 0;
        int mid;

        while(low <= high) {
            mid = low + (high - low)/2 ;

            if((mid == 0 || (array[mid] != array[mid - 1])) && (mid == array.length - 1 || (array[mid] != array[mid + 1]))) {
                return array[mid];
            } else if(mid == 0 || array[mid] == array[mid - 1]) {
                if(mid % 2 == 0) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                if(mid % 2 == 0) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        DuplicateElement duplicateElement = new DuplicateElement();
        System.out.println(duplicateElement.solve(new int[] {3, 3, 1, 1, 8, 8, 10, 10, 19, 6, 6, 2, 2, 4, 4}));
    }
}
