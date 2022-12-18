package coding_challenge_30_day;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.<br/>
 * Note: You can only move either down or right at any point in time.
 *
 * @author sudhir on 27-Apr-2020
 */
public class MinimumPathSum {
    private int ROW = 0;
    private int COL = 0;

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        ROW = grid.length;
        COL = grid[0].length;
        return minPathSum(grid, ROW - 1, COL - 1);
    }

    private int minPathSum(int[][] grid, int row, int col) {
        int[][] cost = new int[row + 1][col + 1];
        cost[0][0] = grid[0][0];
        // fill first row of the matrix
        for (int i = 1; i <= row; i++) {
            cost[i][0] = cost[i - 1][0] + grid[i][0];
        }

        // fill first column of the matrix
        for (int i = 1; i <= col; i++) {
            cost[0][i] = cost[0][i - 1] + grid[0][i];
        }

        // calculate cost in a bottom up manner
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                cost[i][j] = Math.min(cost[i - 1][j] + grid[i][j], cost[i][j - 1] + grid[i][j]);
            }
        }
        return cost[row][col];
    }

    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(m.minPathSum(grid));
    }
}
