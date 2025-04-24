class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        return Math.max(
            helper(nums, 0, nums.length - 2, memo1),
            helper(nums, 1, nums.length - 1, memo2)
        );
    }

    private int helper(int[] nums, int start, int end, int[] memo) {
        if (start > end) return 0;
        if (memo[start] != -1) return memo[start];

        int rob = nums[start] + helper(nums, start + 2, end, memo);
        int skip = helper(nums, start + 1, end, memo);

        memo[start] = Math.max(rob, skip);
        return memo[start];
    }
}
