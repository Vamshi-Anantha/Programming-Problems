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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

// 2nd method
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }

//     private boolean isValid(TreeNode node, long min, long max) {
//         if (node == null) return true; // Base case: empty tree is a valid BST

//         if (node.val <= min || node.val >= max) return false; // Check BST property

//         // Recursively check left and right subtrees with updated boundaries
//         return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
//     }
// }