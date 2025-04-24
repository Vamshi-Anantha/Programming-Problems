// class Solution {
//     public int helper(int[][] grid, int row, int col){
//         if(row >= grid.length || col >= grid[0].length) return 0;
//         if(grid[row][col] == 1) return 0;
//         if(row == grid.length - 1 && col == grid[0].length - 1) return 1;
//         int ans = helper(grid, row + 1, col) + helper(grid, row, col + 1);
//         return ans;
//     }
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         return helper(obstacleGrid, 0, 0);
//     }
// }

class Solution {
    public int helper(int[][] grid, int row, int col, int[][] memo) {
        if (row >= grid.length || col >= grid[0].length) return 0;
        if (grid[row][col] == 1) return 0;
        if (row == grid.length - 1 && col == grid[0].length - 1) return 1;
        if (memo[row][col] != -1) return memo[row][col];
        int ans = memo[row][col] = helper(grid, row + 1, col, memo) + helper(grid, row, col + 1, memo);
        memo[row][col] = ans;
        return ans;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] memo = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(obstacleGrid, 0, 0, memo);
    }
}
