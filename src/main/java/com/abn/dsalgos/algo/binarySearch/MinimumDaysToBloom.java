package com.abn.dsalgos.algo.binarySearch;

public class MinimumDaysToBloom {

    public int minDaysBloom(int[] a, int k, int n) {
        if (a == null || n == 0 || k == 0) return 0;

        if (n * k > a.length) {
            return -1;
        }
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;

        for (int val : a) {
            l = Math.min(l, val);
            r = Math.max(r, val);
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isValid(a, k, n, mid)) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean isValid(int a[], int size, int count, int day) {
        int curcount = 0;
        int cursize = 0;

        for (int val : a) {
            if (val <= day) {
                cursize++;
            } else {
                cursize = 0;
            }
            if (cursize == size) {
                cursize = 0;
                curcount++;
            }
            if (curcount == count)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MinimumDaysToBloom minimumDaysToBloom = new MinimumDaysToBloom();
        minimumDaysToBloom.minDaysBloom(new int[] {1,10,2,9,3,8,4,7,5,6}, 4, 2);
    }
}
