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
    // Helper class to store height and balance status
    public class Pair {
        int height;
        boolean balanced;

        Pair(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    // Recursive helper function
    public Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        // Check if both left and right subtrees are balanced and height difference is at most 1
        if (left.balanced && right.balanced && Math.abs(left.height - right.height) <= 1) {
            return new Pair(Math.max(left.height, right.height) + 1, true);
        }

        // If unbalanced, return false
        // return new Pair(0, false);
        return new Pair(Math.max(left.height, right.height) + 1, false);
    }

    public boolean isBalanced(TreeNode root) {
        return helper(root).balanced;
    }
}
