package com.abn.scalar.dsa.day45;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

class FrequentStack {
    private Stack<Integer> stack;
    private Map<Integer, Integer> frequencyMap;
    private int maxFrequency;

    public FrequentStack() {
        stack = new Stack<>();
        frequencyMap = new HashMap<>();
        maxFrequency = 0;
    }

    public int push(int x) {
        stack.push(x);
        frequencyMap.put(x, frequencyMap.getOrDefault(x, 0) + 1);
        int freq = frequencyMap.get(x);

        if (freq > maxFrequency) {
            maxFrequency = freq;
        }

        return -1;
    }

    public int removeMostFrequent() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        int mostFrequentElement = -1;
        int mostFrequentCount = 0;
        int indexToRemove = -1;

        // Find the most frequent element closest to the top of the stack
        for (int i = stack.size() - 1; i >= 0; i--) {
            int element = stack.get(i);
            int frequency = frequencyMap.get(element);

            if (frequency > mostFrequentCount || (frequency == mostFrequentCount && mostFrequentElement == -1)) {
                mostFrequentElement = element;
                mostFrequentCount = frequency;
                indexToRemove = i;
            }
        }

        // Remove the element from the stack and update frequency map
        stack.remove(indexToRemove);
        frequencyMap.put(mostFrequentElement, mostFrequentCount - 1);

        if (frequencyMap.get(mostFrequentElement) == 0) {
            frequencyMap.remove(mostFrequentElement);
        }

        return mostFrequentElement;
    }

    public List<Integer> processOperations(int[][] operations) {
        List<Integer> result = new ArrayList<>();

        for (int[] operation : operations) {
            if (operation[0] == 1) {
                push(operation[1]);
                result.add(-1);
            } else if (operation[0] == 2) {
                result.add(removeMostFrequent());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FrequentStack fs = new FrequentStack();

        // Example input matrix
        int[][] operations = {
                {1, 4},
                {2, 0},
                {1, 9},
                {2, 0},
                {1, 6},
                {1, 6},
                {2, 0}
        };

        List<Integer> result = fs.processOperations(operations);

        for (int res : result) {
            System.out.println(res);
        }
    }
}
