class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] prevRow = grid[0];

        for (int i = 1; i < n; i++) {
            int[] currRow = new int[n];

            // Find min and second min from previous row
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < n; j++) {
                if (prevRow[j] < min1) {
                    min2 = min1;
                    min1 = prevRow[j];
                    minIndex = j;
                } else if (prevRow[j] < min2) {
                    min2 = prevRow[j];
                }
            }

            for (int j = 0; j < n; j++) {
                if (j == minIndex) {
                    currRow[j] = grid[i][j] + min2;
                } else {
                    currRow[j] = grid[i][j] + min1;
                }
            }

            prevRow = currRow; // Move to next row
        }

        // Return min from the last processed row
        int ans = Integer.MAX_VALUE;
        for (int val : prevRow) {
            ans = Math.min(ans, val);
        }
        return ans;
    }
}
