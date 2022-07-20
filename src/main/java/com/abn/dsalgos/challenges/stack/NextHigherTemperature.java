package com.abn.dsalgos.challenges.stack;

import org.testng.Assert;

import java.util.Stack;

/*
Given an array of integers temperatures represents the daily temperatures,
return an array answer such that answer[i] is the number of days you have to wait after the ith
day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

https://leetcode.com/problems/daily-temperatures/

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

 */
public class NextHigherTemperature {

    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;
        int[] result = new int[len];

        Stack<Temperature> tempStack = new Stack<>();

        for(int i = len - 1; i >=0; i --) {
            while(!tempStack.isEmpty() && temperatures[i] >= tempStack.peek().getTempValue()) {
                tempStack.pop();
            }

            result[i] = tempStack.isEmpty() ? 0 : Math.abs(tempStack.peek().getIndex() - i);
            tempStack.push(new Temperature(i, temperatures[i]));
        }

        return result;
    }

    public static void main(String[] args) {

        NextHigherTemperature nextHigherTemperature = new NextHigherTemperature();
        Assert.assertEquals(nextHigherTemperature.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}), new int[] {1,1,4,2,1,1,0,0});
    }
}

class Temperature {

    private int index;
    private int tempValue;

    public Temperature(int index, int tempValue) {
        this.index = index;
        this.tempValue = tempValue;

    }

    public int getIndex() {
        return this.index;
    }

    public int getTempValue() {
        return this.tempValue;
    }
}
