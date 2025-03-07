package com.abn.scalar.dsa.day51;

import java.util.ArrayList;
import java.util.List;

/*
You are climbing a staircase and it takes A steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

You need to return all the distinct ways to climb to the top in lexicographical order.


 */
public class PrintPathInStaircase {

    public List<List<Integer>> climbStairs(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, new ArrayList<>(), result);

        // Sort the result lexicographically
        result.sort((a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i).compareTo(b.get(i));
                }
            }
            return Integer.compare(a.size(), b.size());
        });

        return result;
    }

    private void backtrack(int remainingSteps,
                           List<Integer> currentPath,
                           List<List<Integer>> result) {
        // Base cases
        if (remainingSteps < 0) {
            return;
        }

        if (remainingSteps == 0) {
            // Found a valid path, create a copy and add to result
            result.add(new ArrayList<>(currentPath));
            return;
        }

        // Try climbing 1 step
        currentPath.add(1);
        backtrack(remainingSteps - 1, currentPath, result);
        currentPath.remove(currentPath.size() - 1);

        // Try climbing 2 steps
        currentPath.add(2);
        backtrack(remainingSteps - 2, currentPath, result);
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {

        PrintPathInStaircase printPathInStaircase = new PrintPathInStaircase();
        System.out.println(printPathInStaircase.climbStairs(3));
    }
}
