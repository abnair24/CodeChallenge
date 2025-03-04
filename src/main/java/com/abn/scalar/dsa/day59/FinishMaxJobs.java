package com.abn.scalar.dsa.day59;

import java.util.Arrays;
import java.util.Comparator;

/*
There are N jobs to be done, but you can do only one job at a time.

Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.

Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

Return the maximum number of jobs you can finish.

A = [1, 5, 7, 1]
 B = [7, 8, 8, 8]

 o/p: 2

 A = [3, 2, 6]
 B = [9, 8, 9]

 o/p: 1

 Approach:

 Sort by end time
 */

class Job {
    int start;
    int end;

    public Job(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class FinishMaxJobs {

    public int solve(int[] A, int[] B) {

        Job[] jobs = new Job[A.length];

        for(int i = 0; i < A.length; i++) {
            jobs[i] = new Job(A[i], B[i]);
        }

        Arrays.sort(jobs, new Comparator<Job>() {
                    public int compare(Job o1, Job o2) {
                        if (o1.end == o2.end) {
                            return 1;
                        } else {
                            return o1.end - o2.end;
                        }
                    }
                }
        );

        int count = 1;
        int endTime = jobs[0].end;

        for(int i = 1; i < jobs.length; i++) {
            if(jobs[i].start >= endTime) {
                count ++;
                endTime = jobs[i].end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] start = new int[] {1, 5, 7, 1};
        int[] end = new int[] {7, 8, 8, 8};
//
        FinishMaxJobs maxJobs = new FinishMaxJobs();
        System.out.println(maxJobs.solve(start, end));

        int[] start1 = new int[] {4,4,8,15,6};
        int[] end1 = new int[] {9,5,15,16,7};

        System.out.println(maxJobs.solve(start1, end1));

        int[] start2 = new int[] {3,7,12,4,10,8};
        int[] end2 = new int[] {10,16,17,8,13,9};

        System.out.println(maxJobs.solve(start2, end2));
    }
}

