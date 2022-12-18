package com.leetcode.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].<br/>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.<br/>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 *
 * @author sudhir on 14-May-2020
 */
public class GasStation {
    /**
     * This approach uses two pointers start and end and no extra data structure.
     * Run time in leetcode: 0 ms
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cursum = 0;
        int start = 0;
        int end = 0;
        int stationCount = 0;
        // when we get all the stations we break out of the loop and return the index of start station.
        while (stationCount < gas.length) {
            cursum += (gas[end] - cost[end]);
            end = (end + 1) % gas.length;
            stationCount++;
            while (cursum < 0) {
                cursum -= (gas[start] - cost[start]);
                start++;
                // if start reaches gas.length, then it means no solution exists, so we can return -1.
                if (start == gas.length) {
                    return -1;
                }
                stationCount--;
            }
        }
        return start;
    }

    /**
     * This approach uses queue. Any time in the queue, queue's peek() points to the starting station index.
     * Run time in leetcode: 2 ms
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int cursum = 0;
        Queue<Integer> queue = new LinkedList<>();
        int queueSize = 0;
        int i = 0;
        int j = 0;
        while (i < 2 * gas.length) {
            while (!queue.isEmpty() && cursum < 0) {
                int index = queue.poll();
                cursum -= (gas[index] - cost[index]);
                queueSize--;
            }
            cursum += (gas[j] - cost[j]);
            queueSize++;
            queue.offer(j);
            j = (i + 1) % gas.length;
            if (queueSize == gas.length) {
                break;
            }
            i++;
        }
        if (cursum >= 0 && queueSize == gas.length) {
            return queue.peek();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        GasStation g = new GasStation();
        int[] gas1 = {5};
        int[] cost1 = {4};
        int[] gas2 = {1, 2, 3, 4, 5};
        int[] cost2 = {3, 4, 5, 1, 2};
        int[] gas3 = {2, 3, 4};
        int[] cost3 = {3, 4, 3};
        System.out.println(g.canCompleteCircuit(gas1, cost1));
        System.out.println(g.canCompleteCircuit(gas2, cost2));
        System.out.println(g.canCompleteCircuit(gas3, cost3));
    }
}
