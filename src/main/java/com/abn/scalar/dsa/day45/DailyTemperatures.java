package com.abn.scalar.dsa.day45;

import java.util.Arrays;
import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // To store indices of temperatures

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        // Remaining indices in stack have no warmer days
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();

        // Example input
        int[] temperatures = {75, 71, 69, 72, 76, 73};

        // Calculate result
        int[] result = dt.dailyTemperatures(temperatures);

        // Print result
        System.out.println(Arrays.toString(result));
    }
}
