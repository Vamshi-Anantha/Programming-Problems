// class Solution {
//     public int countSubarrays(int[] nums) {
//         int count = 0;
        
//         for (int i = 0; i <= nums.length - 3; i++) {
//             int first = nums[i];
//             int middle = nums[i + 1];
//             int third = nums[i + 2];
            
//             if (first + third == middle / 2) {
//                 count++;
//             }
//         }
        
//         return count;
//     }
// }
class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i + 2 < n; i++) {
            if (nums[i+1] % 2 == 0 && nums[i] + nums[i+2] == nums[i+1] / 2) {
                count++;
            }
        }
        
        return count;
    }
}

