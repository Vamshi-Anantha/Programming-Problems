class Solution {
    int helper(int[][] matrix, int[][] memo, int row, int col) {
        int n = matrix.length;

        // Out of bounds
        if (col < 0 || col >= n) return Integer.MAX_VALUE;

        // Last row
        if (row == n - 1) return matrix[row][col];

        if (memo[row][col] != Integer.MAX_VALUE) return memo[row][col];

        int choice1 = helper(matrix, memo, row + 1, col - 1);
        int choice2 = helper(matrix, memo, row + 1, col);
        int choice3 = helper(matrix, memo, row + 1, col + 1);

        memo[row][col] = matrix[row][col] + Math.min(choice1, Math.min(choice2, choice3));
        return memo[row][col];
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minSum = Integer.MAX_VALUE;
        int[][] memo = new int[n][n];

        // Initialize memo with max values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, helper(matrix, memo, 0, col));
        }

        return minSum;
    }
}
