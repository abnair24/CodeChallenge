package com.abn.dsalgos.cockroach;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem7 {

    public void deckOfCards(int[] nums) {

        int[] result = new int[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.sort(nums);

        for(int i=0; i< nums.length; i++) {
            queue.offer(i);
        }

        int i = 0;
        while(!queue.isEmpty()) {
            result[queue.poll()] = nums[i];

            if(!queue.isEmpty()) {
                queue.offer(queue.poll());
                i++;
            }
        }

        for(int k = 0; k < result.length; k++) {
            System.out.print(result[k] + ", ");
        }
    }

    public static void main(String[] args) {

        Problem7 problem7 = new Problem7();
        int[] nums = {4, 3, 7, 5, 8, 1};
        problem7.deckOfCards(nums);
    }
}
