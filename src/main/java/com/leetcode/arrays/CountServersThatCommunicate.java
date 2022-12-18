package com.leetcode.arrays;

import com.leetcode.utilities.FastReader;

/**
 * You are given a map of a server center, represented as a m * n integer matrix grid,
 * where 1 means that on that cell there is a server and 0 means that it is no server.
 * Two servers are said to communicate if they are on the same row or on the same column.
 * Return the number of servers that communicate with any other server.
 * <p>
 * <li>
 * Input: grid = [[1,0],[0,1]]
 * </li>
 * <li>
 * Output: 0
 * </li>
 * <li>
 * Explanation: No servers can communicate with others.
 * </li>
 * </p>
 * <p>
 * <li>
 * Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * </li>
 * <li>
 * Output: 4
 * </li>
 * <li>
 * Explanation: The two servers in the first row can communicate with each other.
 * The two servers in the third column can communicate with each other.
 * The server at right bottom corner can't communicate with any other server.
 * </li>
 * </p>
 * <p>
 * <li>
 * Input: grid = [[1,0,0,1,0],[0,0,0,0,0],[0,0,0,1,0]]
 * </li>
 * <li>
 * Output: 3
 * </li>
 * <li>
 * Explanation: The two servers in the first row can communicate with each other.
 * The fourth server in the third row can communicate with the other server in the same column.
 * </li>
 * </p>
 *
 * @author sudhir on 10-Jan-2020
 */
public class CountServersThatCommunicate {
    public static int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    total++;
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int orphan = 0;
        for (int i = 0; i < m; i++) {
            if (row[i] > 1) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (col[j] == 1 && grid[i][j] == 1) {
                    orphan++;
                }
            }
        }
        return total - orphan;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int m = fr.nextInt();
        int n = fr.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = fr.nextInt();
            }
        }
        System.out.println(countServers(grid));
        fr.close();
    }
}
