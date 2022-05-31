package com.abn.dsalgos.algo.mergeIntervals;

import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Given a list of intervals representing the start and end time of ‘N’ meetings,
find the minimum number of rooms required to hold all the meetings.

Meetings: [[1,4], [2,5], [7,9]]
Output: 2
Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
occur in any of the two rooms later.

Meetings: [[6,7], [2,4], [8,12]]
Output: 1
Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
 */
public class MinmimumMeetingRooms {

    public int minimumRooms(List<Meeting> meetings) {

        if(meetings == null || meetings.size() ==0 ){
            return 0;
        }

        int minrooms =0;

        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Meeting> priorityQueue = new PriorityQueue<>(meetings.size(), (a,b) -> Integer.compare(a.end, b.end));

        for(Meeting meeting : meetings) {
            while(!priorityQueue.isEmpty() && meeting.start >= priorityQueue.peek().end) {
                priorityQueue.poll();
            }
            priorityQueue.add(meeting);
            minrooms = Math.max(minrooms, priorityQueue.size());
        }

        return minrooms;
    }

    public static void main(String[] args) {

        Meeting meeting1 = new Meeting(0, 30);
        Meeting meeting2 = new Meeting(5, 10);
        Meeting meeting3 = new Meeting(15, 20);

        List<Meeting> input = Arrays.asList(meeting1, meeting2, meeting3);

        MinmimumMeetingRooms meetingRooms = new MinmimumMeetingRooms();
        Assert.assertEquals(meetingRooms.minimumRooms(input), 2);

        Meeting meeting4 = new Meeting(4, 5);
        Meeting meeting5 = new Meeting(2, 3);
        Meeting meeting6 = new Meeting(2, 4);
        Meeting meeting7 = new Meeting(3, 5);
        List<Meeting> input1 = Arrays.asList(meeting4, meeting5, meeting6, meeting7);
        Assert.assertEquals(meetingRooms.minimumRooms(input1), 2);
    }
}

class Meeting {

    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
