// class Solution {
//     public long countSubarrays(int[] nums, int k) {
        
//     }
// }


class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxVal = 0;

        // Step 1: Find the maximum value in the array
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        long count = 0;
        int left = 0, maxCount = 0;

        // Step 2: Sliding window
        for (int right = 0; right < n; right++) {
            if (nums[right] == maxVal) {
                maxCount++;
            }

            while (maxCount >= k) {
                // All subarrays starting from left to right are valid
                count += (n - right);
                if (nums[left] == maxVal) {
                    maxCount--;
                }
                left++;
            }
        }

        return count;
    }
}
