class Solution {
    public int helper(int currentRow, int currentCol, int m, int n, int[][] memo) {
        if (currentRow == m && currentCol == n) return 1;
        if (currentRow > m || currentCol > n) return 0;

        if (memo[currentRow][currentCol] != -1) {
            return memo[currentRow][currentCol];
        }

        int ans = helper(currentRow + 1, currentCol, m, n, memo) + helper(currentRow, currentCol + 1, m, n, memo);
        memo[currentRow][currentCol] = ans;
        return ans;
    }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m + 1][n + 1]; 
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(1, 1, m, n, memo);
    }
}
