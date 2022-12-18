package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * <p>
 * Output: [[1,6],[8,10],[15,18]]
 * <p>
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * <p>
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * <p>
 * Output: [[1,5]]
 * <p>
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * @author sudhir on 23-Sep-2020
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] toInsert = intervals[0];
        int i = 1;
        List<int[]> list = new ArrayList<>();
        while (i < intervals.length) {
            if (toInsert[1] >= intervals[i][0]) {
                toInsert[1] = Math.max(toInsert[1], intervals[i][1]);
            } else {
                list.add(toInsert);
                toInsert = intervals[i];
            }
            i++;
        }
        list.add(toInsert);
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result1 = mergeIntervals.merge(intervals1);
        int[][] result2 = mergeIntervals.merge(intervals2);
        for (int[] row : result1) {
            System.out.print(Arrays.toString(row) + ",");
        }
        System.out.println();
        for (int[] row : result2) {
            System.out.println(Arrays.toString(row));
        }
    }
}
