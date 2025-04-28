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
// class Solution {
//     public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
//     }
// }

class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;  // Both null: OK
        if (root1 == null || root2 == null) return false; // One null: Not OK
        if (root1.val != root2.val) return false;         // Values different: Not OK
        
        // Check two possibilities:
        // 1. No flip: left-left and right-right
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        
        // 2. Flip: left-right and right-left
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        return noFlip || flip;
    }
}
