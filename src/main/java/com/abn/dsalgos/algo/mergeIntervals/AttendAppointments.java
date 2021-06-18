package com.abn.dsalgos.algo.mergeIntervals;

import com.abn.dsalgos.utils.Interval;

import java.util.Arrays;

/*
Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

Appointments: [[1,4], [2,5], [7,9]]
Output: false

Appointments: [[6,7], [2,4], [8,12]]
Output: true

Appointments: [[4,5], [2,3], [3,6]]
Output: false

If overlapping appointments are there, then he cant attend all appointments
 */

//TO-DO: tests
public class AttendAppointments {

    public boolean canAttend(Interval[] appointments) {

        if (appointments.length < 2) {
            return true;
        }

        Arrays.sort(appointments, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < appointments.length; i++) {

            // if true, appointments are overlapping.
            // Then all appointments cant be attending => false
            if (appointments[i].start < appointments[i - 1].end) {
                return false;
            }
        }
        return true;
    }
}
