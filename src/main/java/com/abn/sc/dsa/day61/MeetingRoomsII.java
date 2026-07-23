package com.abn.sc.dsa.day61;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
You are given an array B of meeting time intervals where each interval is represented as [start, end] (with start < end).
 You need to find the minimum number of conference rooms required to host all the meetings.
 Input Format

First Argument is an Integer A, denoting the number of meetings.
Second Argument is a 2-D integer Array B of Size Ax2, representing the start and end timing of the meetings.


Output Format

Return a single integer representing the minimum number of conference rooms required.
A = 3
B = [ [0, 30],
      [5, 10],
      [15, 20] ]
Input 2:
A = 1
B = [ [0, 1] ]


Example Output

Output 1:
2
Output 2:
1


 */
public class MeetingRoomsII {

    public int solve(int rooms, int[][] meetings) {
        if (meetings == null || meetings.length == 0 || rooms == 0) {
            return 0;
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(meetings[0][1]);

        for (int i = 1; i < meetings.length; i++) {
            // If current meeting starts after or when the earliest meeting ends
            if (meetings[i][0] >= minHeap.peek()) {
                minHeap.poll(); // Reuse the room
            }
            minHeap.offer(meetings[i][1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {

        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        System.out.println(meetingRoomsII.solve(2, new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(meetingRoomsII.solve(3, new int[][]{{7, 10}, {2, 4}}));
    }
}
