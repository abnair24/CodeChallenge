package com.abn.learn.dsa.day20;

/*
Given N buildings with height of each building, find the rain water
trapped between the buildings.

Example Explanation
Example: arr[] = {2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1}

We now need to find the rainwater trapped between the buildings

Logic:
Rainwater trapped for each building will be Min(Max ht left building, Max ht right building) - current building ht

Form for each building left max array and right max array

leftMax at an index will be max of (leftMax till previous index, previous index value)
rightMax at an index will be max of (rightMax till i+1, i+1 index value)
 */
public class RainWaterTrapped {

    public int solve(int[] height) {

        int[] leftMaxArray = new int[height.length];
        int[] rightMaxArray = new int[height.length];
        int vol = 0;
        int trapped = 0;

        for(int i = 1; i < height.length; i++) {
            leftMaxArray[i] = Math.max(leftMaxArray[i - 1], height[i - 1]);
        }

        for(int i = height.length - 2; i >= 0; i --) {
            rightMaxArray[i] = Math.max(rightMaxArray[i + 1], height[i + 1]);
        }

        // water trapped

        for(int i = 1; i < height.length - 1; i ++) {

            vol = Math.min(leftMaxArray[i], rightMaxArray[i]) - height[i];

            if(vol > 0) {
                trapped = trapped + vol;
            }
        }

        return trapped;
    }

    public static void main(String[] args) {

        int[] array = new int[] {4, 2, 5, 7, 4, 2, 3, 6, 8, 2, 3};

        RainWaterTrapped rainWaterTrapped = new RainWaterTrapped();
        rainWaterTrapped.solve(array);
    }
}
