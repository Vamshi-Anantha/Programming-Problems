/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//  1st approach
class Solution {
    // Helper method to build the BST
    public TreeNode helper(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;

        // Choose the middle element to keep tree balanced
        int mid = (startIndex + endIndex) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build left and right subtrees
        root.left = helper(nums, startIndex, mid - 1);
        root.right = helper(nums, mid + 1, endIndex);

        return root;
    }

    // Main method to be called
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}
//  2nd approach
// class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {
//         return helper(nums, 0, nums.length - 1);
//     }

//     private TreeNode helper(int[] nums, int startIndex, int endIndex) {
//         if (startIndex > endIndex) return null;

//         int mid = (startIndex + endIndex) / 2;
//         TreeNode root = new TreeNode(nums[mid]);

//         root.left = helper(nums, startIndex, mid - 1);
//         root.right = helper(nums, mid + 1, endIndex);

//         return root;
//     }
// }