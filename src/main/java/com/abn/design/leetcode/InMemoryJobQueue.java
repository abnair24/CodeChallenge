package com.abn.design.leetcode;

/*
Design an in-memory system for managing pending jobs.
// Each job has an ID and priority.
// Support:/
/ add(job_id, priority)
// update_priority(job_id, new_priority)
// cancel(job_id)// pop_next()
// pop_next() removes and returns the highest-priority job.

If two jobs have the same priority, return the one added first.
// Input:
// add(A, 2)
// add(B, 5)
// add(C, 5)
// pop_next() → B
// update_priority(A, 5)
// add(D, 8)
// pop_next() → D
// cancel(C)
// pop_next() → A
// pop_next() → EMPTY//
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TimeZone;

class Job {
    int priority;
    String name;
    Long time;

    public Job(String name, int priority, Long time) {
        this.name = name;
        this.priority = priority;
        this.time = time;
    }
}

public class InMemoryJobQueue {

    Map<String, Job> map = new HashMap<>();

    // Priority Queue
    PriorityQueue<Job> pq = new PriorityQueue<>(
            (a, b) -> a.priority != b.priority ?
                    Integer.compare(b.priority, a.priority) : Long.compare(a.time, b.time));

    private long counter = 0;

    public void add(String jobId, int priority) {

        if(map.containsKey(jobId)) {
            return;
        }
        Job job = new Job(jobId, priority, counter++);
        pq.add(job);
        map.put(jobId, job);
    }

    public void updatePriority(String jobId, int priority) {
        Job old = map.get(jobId);
        if(old == null) {
            return;
        }

        Job newJob = new Job(jobId, priority, old.time);
        pq.add(newJob);
        map.put(jobId, newJob);
    }

    public String pop() {

        while(!pq.isEmpty()) {
            Job job = pq.poll();

            // since cancelled jobs are not removed from pq, popped value is checked against presence in map,
            // if not in map, that means it was cancelled, so pop will be done again till map has the job id.

            if(map.get(job.name) != null) {
                map.remove(job.name);
                return job.name;
            }
        }
        return "EMPTY";
    }

    public void cancel(String jobId) {

        // Cancelling job is removed only from map as removing from PQ is expensive,
        // in the pop cycle its handled by checking popped value and map value same or not.
        map.remove(jobId);
    }

    public static void main(String[] args) {

        InMemoryJobQueue inMemoryJobQueue = new InMemoryJobQueue();
        inMemoryJobQueue.add("A", 2);
        inMemoryJobQueue.add("B", 5);
        inMemoryJobQueue.add("C", 5);
        System.out.println(inMemoryJobQueue.pop()); // B
        inMemoryJobQueue.updatePriority("A", 5);
        inMemoryJobQueue.add("D", 8);
        System.out.println(inMemoryJobQueue.pop()); // D
        inMemoryJobQueue.cancel("A");
        System.out.println(inMemoryJobQueue.pop()); // C
        System.out.println(inMemoryJobQueue.pop()); // EMPTY
    }
}
