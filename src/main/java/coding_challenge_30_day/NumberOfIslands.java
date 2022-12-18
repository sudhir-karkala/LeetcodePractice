package coding_challenge_30_day;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. <br/>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. <br/>
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * @author sudhir on 27-Apr-2020
 */
public class NumberOfIslands {
    private int ROW = 0;
    private int COL = 0;
    private int directions = 4;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        ROW = grid.length;
        COL = grid[0].length;
        // maintain visited array for every cell
        boolean[][] visited = new boolean[ROW][COL];
        int islands = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    DFS(grid, visited, i, j);
                    // once a DFS traversal is done, we update island count and start with next island
                    islands++;
                }
            }
        }
        return islands;
    }

    private boolean isPossible(char[][] grid, int row, int col, boolean[][] visited) {
        return (row >= 0 && row < ROW) && (col >= 0 && col < COL) && (grid[row][col] == '1' && !visited[row][col]);
    }

    private void DFS(char[][] grid, boolean[][] visited, int row, int col) {
        // initialize row numbers for 4 directions
        // i.e. top of current, left of current, right of current, bottom of current.
        int[] rowNumbers = {-1, 0, 0, 1};
        // initialize col numbers for 4 directions
        int[] colNumbers = {0, -1, 1, 0};
        visited[row][col] = true;
        for (int k = 0; k < directions; k++) {
            if (isPossible(grid, row + rowNumbers[k], col + colNumbers[k], visited)) {
                DFS(grid, visited, row + rowNumbers[k], col + colNumbers[k]);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] grid2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numberOfIslands.numIslands(grid1));
        System.out.println(numberOfIslands.numIslands(grid2));
    }
}
