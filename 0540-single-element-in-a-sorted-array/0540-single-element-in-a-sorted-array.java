// 1st method
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        if (nums.length == 1) return nums[0];
        if (nums[low] != nums[low + 1]) return nums[low];
        if (nums[high] != nums[high - 1]) return nums[high];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                    return nums[mid];
                }
            }

            if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (mid > 0 && nums[mid] == nums[mid - 1]) {
                if ((mid - 1) % 2 == 0) {
                    low = mid + 1;
                } else {
                    high = mid - 2;
                }
            }
        }
        return -1;
    }
}

// 2nd method
// class Solution {
//     public int singleNonDuplicate(int[] nums) {
//         int low = 0, high = nums.length - 1;
//         while (low < high){
//             int mid = low + (high - low) / 2;
//             if(mid % 2 == 1) mid--;
//             if(nums[mid] == nums[mid + 1]){
//                 low = mid + 2;
//             }else{
//                 high = mid;
//             }
//         }
//         return nums[low];
//     }
// }