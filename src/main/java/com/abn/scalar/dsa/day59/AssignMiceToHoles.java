package com.abn.scalar.dsa.day59;

import java.util.Arrays;

/*N Mice and N holes are placed in a straight line. Each hole can accommodate only one mouse.
The positions of Mice are denoted by array A, and the position of holes is denoted by array B.

A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1.
Any of these moves consume 1 minute.

Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.

Input 1:

 A = [-4, 2, 3]
 B = [0, -2, 4]

 2

Input 2:

 A = [-2]
 B = [-6]

 4
 */
public class AssignMiceToHoles {

    public int mice(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            ans = Math.max(ans, Math.abs(A[i] - B[i]));
        }
        return ans;
    }

    public static void main(String[] args) {

        AssignMiceToHoles assignMiceToHoles = new AssignMiceToHoles();
        System.out.println(assignMiceToHoles.mice(new int[]{-4, 2, 3}, new int[]{0, -2, 4}));
    }
}
