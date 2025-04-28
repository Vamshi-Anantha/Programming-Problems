// class Solution {
//     public int findMaxLength(int[] nums) {
        
//     }
// } 

// import java.util.HashMap;

// class Solution {
//     public int findMaxLength(int[] nums) {
//         // Map to store the first occurrence of prefix sum
//         HashMap<Integer, Integer> map = new HashMap<>();
        
//         // Initialize variables
//         map.put(0, -1);  // Handle case when subarray starts from index 0
//         int maxLength = 0;
//         int prefixSum = 0;
        
//         // Traverse the array
//         for (int i = 0; i < nums.length; i++) {
//             // Convert 0 to -1 to make it easier to find the sum equal to 0
//             prefixSum += (nums[i] == 0) ? -1 : 1;
            
//             // If prefixSum already exists, a subarray with equal 0s and 1s exists
//             if (map.containsKey(prefixSum)) {
//                 maxLength = Math.max(maxLength, i - map.get(prefixSum));
//             } else {
//                 // Store the first occurrence of this prefix sum
//                 map.put(prefixSum, i);
//             }
//         }
        
//         return maxLength;
//     }
// }



// Dp
class Solution {
    public int findMaxLength(int[] nums) {
        // Initialize a map to store the first occurrence of cumulative sum
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Handle the case where the subarray starts from index 0
        
        int maxLength = 0;
        int cumulativeSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Update the cumulative sum
            cumulativeSum += (nums[i] == 0) ? -1 : 1;
            
            // Check if the cumulative sum has been seen before
            if (map.containsKey(cumulativeSum)) {
                // Calculate the length of the subarray
                maxLength = Math.max(maxLength, i - map.get(cumulativeSum));
            } else {
                // Store the first occurrence of this cumulative sum
                map.put(cumulativeSum, i);
            }
        }
        
        return maxLength;
    }
}
