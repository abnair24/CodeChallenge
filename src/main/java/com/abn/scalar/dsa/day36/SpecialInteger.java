package com.abn.scalar.dsa.day36;

public class SpecialInteger {

    // Example usage method
    public static void main(String[] args) {
        SpecialInteger solution = new SpecialInteger();

        // Test cases
        int[] arr1 = {1, 2, 3, 4, 5};
        int B1 = 10;
        System.out.println(solution.findMaxSubarraySize(arr1, B1)); // Expected output: 2

        int[] arr2 = {5, 17, 100, 11};
        int B2 = 130;
        System.out.println(solution.findMaxSubarraySize(arr2, B2)); // Expected output: 3
    }

    public int findMaxSubarraySize(int[] A, int B) {
        int l = 0, r = A.length;
        int ans = 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (getSum(A, mid, B)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private boolean getSum(int[] A, int mid, int B) {
        int N = A.length;
        int sum = 0;
        int last = 0;
        for (int i = 0; i < N; i++) {
            if (i >= mid) {
                last = A[i - mid];
            }
            int diff = A[i] - last;
            sum += diff;
            if (sum > B) {
                return false;
            }
        }

        return true;
    }
}
