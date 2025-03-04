package com.abn.scalar.dsa.day49;

public class ContainerWithMostWater {

    public int solve(int[] array) {

        int len = array.length;
        int startPtr = 0;
        int endPtr = array.length - 1;

        int maxArea = 0;

        if(len == 1) {
            return 0;
        }

        while(startPtr < endPtr) {

            int waterContained = (endPtr - startPtr) * Math.min(array[startPtr], array[endPtr]);
            maxArea = Math.max(waterContained, maxArea);

            if(array[startPtr] <= array[endPtr]) {
                startPtr ++;
            } else {
                endPtr --;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.solve(new int[] {1, 5, 4 , 3}));
    }
}
