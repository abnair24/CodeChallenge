package com.abn.scalar.dsa.day26Recursion2;

import java.util.ArrayList;

/*
The Tower of Hanoi problem can be solved using recursion.
* The steps to solve the problem for N disks are:
* 1. Move N-1 disks from the source tower to the intermediate tower.
* 2. Move the Nth (largest) disk from the source tower to the destination tower.
* 3. Move the N-1 disks from the intermediate tower to the destination tower.
 */

public class TowerOfHanoi {

    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> solve(int A) {
        result = new ArrayList<>();
        solveTowerOfHanoi(A, 1, 3, 2);
        return result;
    }

    private void solveTowerOfHanoi(int A, int start, int end, int temp) {

        if(A == 0) {
            return;
        }

        /// Move N-1 disks from start to intermediate using end as auxiliary
        solveTowerOfHanoi(A-1, start, temp, end);

        // Move the Nth disk from start to end
        ArrayList<Integer> list = new ArrayList<>();
        list.add(A);
        list.add(start);
        list.add(end);
        result.add(list);

        // Move the N-1 disks from intermediate to end using start as auxiliary
        solveTowerOfHanoi(A-1, temp, end, start);
    }

    public static void main(String[] args) {

        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        System.out.println(towerOfHanoi.solve(1));
        System.out.println(towerOfHanoi.solve(2));
        System.out.println(towerOfHanoi.solve(3));
    }
}
