package com.abn.dsalgos.algo.mergeIntervals;

import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
find the maximum CPU load at any time if all the jobs are running on the same machine.

Jobs: [[1,4,3], [2,5,4], [7,9,6]]
Output: 7

Jobs: [[6,7,10], [2,4,11], [8,12,15]]
Output: 15

 */

public class MaximumCPULoad {

    public int maxLoad(List<Task> tasks) {

        Collections.sort(tasks, (a, b) -> Integer.compare(a.start, b.start));

        int currentLoad = 0;
        int maxLoad = Integer.MIN_VALUE;

        PriorityQueue<Task> minHeap = new PriorityQueue<>(tasks.size(), (a, b) -> Integer.compare(a.end, b.end));

        for(Task task : tasks) {

            while(!minHeap.isEmpty() && task.start > minHeap.peek().end) {
                minHeap.poll();
                currentLoad = currentLoad - task.load;
            }

            minHeap.add(task);
            currentLoad += task.load;
            maxLoad = Math.max(maxLoad, currentLoad);
        }

        return maxLoad;
    }

    public static void main(String[] args) {

        Task task1 = new Task(1, 4, 2);
        Task task2 = new Task(2, 4, 1);
        Task task3 = new Task(3, 6, 5);

        List<Task> input = Arrays.asList(task1, task2, task3);

        MaximumCPULoad maximumCPULoad = new MaximumCPULoad();
        Assert.assertEquals(maximumCPULoad.maxLoad(input), 8);
    }
}

class Task {

    int start;
    int end;
    int load;

    public Task(int start, int end, int load) {
        this.start = start;
        this.end = end;
        this.load = load;
    }
}
