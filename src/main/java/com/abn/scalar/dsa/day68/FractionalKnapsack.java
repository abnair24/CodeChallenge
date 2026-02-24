package com.abn.scalar.dsa.day68;

import java.util.Arrays;

/*
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
Also given an integer C which represents knapsack capacity.
Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).

NOTE:
You can break an item for maximizing the total value of the knapsack

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
 */

class Items {

    int value;
    int weight;
    double ratio;

    public Items(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value/ weight;
    }
}

public class FractionalKnapsack {

    public int solve(int[] values, int[] weights, int capacity) {

        int n = values.length;

        Items[] items = new Items[n];

        for(int i = 0; i < n; i++) {
            items[i] = new Items(values[i], weights[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        int currentWeight = 0;

        for (int i = 0; i < n; i++) {
            Items item = items[i];

            if(currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                int remainingWeight = capacity - currentWeight;
                if (remainingWeight > 0) {
                    double fraction = (double) remainingWeight / item.weight;
                    totalValue = fraction * item.value + totalValue;
                }
                break;
            }
        }
        return (int) Math.floor(totalValue * 100 +  1e-9);
    }

    public static void main(String[] args) {
        FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();
        System.out.println(fractionalKnapsack.solve(new int[] {60, 100, 120}, new int[] {10, 20, 30}, 50));
    }
}


