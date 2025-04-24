class Solution {
    int helper(int[][] grid, int[][] memo, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        if (row >= m || col >= n) return Integer.MAX_VALUE;
        if (row == m - 1 && col == n - 1) return grid[row][col];
        if (memo[row][col] != -1) return memo[row][col];

        int choice1 = helper(grid, memo, row + 1, col);
        int choice2 = helper(grid, memo, row, col + 1);

        memo[row][col] = grid[row][col] + Math.min(choice1, choice2);
        return memo[row][col];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return helper(grid, memo, 0, 0);
    }
}
