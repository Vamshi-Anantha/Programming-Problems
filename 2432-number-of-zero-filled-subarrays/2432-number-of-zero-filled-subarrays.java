class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;  // To store the total number of zero-filled subarrays
        long zeroCount = 0;  // To track the length of the current zero-filled segment
        
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;  // Increase the length of the current zero-filled segment
            } else {
                if (zeroCount > 0) {
                    // Add the number of zero-filled subarrays for this segment
                    count += zeroCount * (zeroCount + 1) / 2;
                    zeroCount = 0;  // Reset the zero segment length
                }
            }
        }
        
        // If the array ends with a zero segment, add the remaining count
        if (zeroCount > 0) {
            count += zeroCount * (zeroCount + 1) / 2;
        }
        
        return count;
    }
}
