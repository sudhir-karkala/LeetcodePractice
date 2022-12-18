package coding_challenge_30_day;

/**
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix,
 * this row is sorted in non-decreasing order.<br/>
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it.
 * If such index doesn't exist, return -1.
 *
 * @author sudhir on 27-Apr-2020
 */

import java.util.List;

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 * public int get(int row, int col) {}
 * public List<Integer> dimensions {}
 * };
 */

public class LeftmostColumnWithAtLeastAOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = dimensions.get(0);
        int col = dimensions.get(1);
        // do binary search for every row.
        int result = binarySearch(binaryMatrix, row, col);
        return result;
    }

    private int binarySearch(BinaryMatrix binaryMatrix, int row, int col) {
        int r = 0;
        int left = Integer.MAX_VALUE;
        int low;
        int high;
        while (r < row) {
            low = 0;
            high = col - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (binaryMatrix.get(r, mid) == 1) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (low == col) low = Integer.MAX_VALUE;
            left = Math.min(left, low);
            r++;
        }
        return left == Integer.MAX_VALUE ? -1 : left;
    }
}
