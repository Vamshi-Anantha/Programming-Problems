class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            ans += map.getOrDefault(sum - k, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}




// import java.util.HashMap;

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         // Map to store the frequency of prefix sums
//         HashMap<Integer, Integer> map = new HashMap<>();
//         map.put(0, 1); // Initialize with 0:1 to handle the case where the prefix sum equals k
//         int prefixSum = 0;
//         int count = 0;
        
//         // Iterate through the array
//         for (int num : nums) {
//             // Update the prefix sum
//             prefixSum += num;
            
//             // If prefixSum - k has been seen before, it means there is a subarray that sums to k
//             if (map.containsKey(prefixSum - k)) {
//                 count += map.get(prefixSum - k);
//             }
            
//             // Update the map with the current prefix sum
//             map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
//         }
        
//         return count; // Return the total number of subarrays whose sum equals k
//     }
// }
