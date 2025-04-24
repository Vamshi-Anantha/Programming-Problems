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
// 1st approach
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        // Step 1: Recursively flatten left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // Step 2: Store left and right subtrees
        TreeNode leftTemp = root.left;
        TreeNode rightTemp = root.right;

        // Step 3: Nullify left and attach left subtree to the right
        root.left = null;
        root.right = leftTemp;

        // Step 4: Find the tail of the new right subtree
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }

        // Step 5: Attach the original right subtree
        curr.right = rightTemp;
    }
}
//  2nd approach
// class Solution {
//     private TreeNode prev = null;

//     public void flatten(TreeNode root) {
//         if (root == null) return;

//         // Step 1: Flatten right subtree first
//         flatten(root.right);
//         // Step 2: Flatten left subtree next
//         flatten(root.left);

//         // Step 3: Rearrange pointers
//         root.right = prev;
//         root.left = null;
//         prev = root;
//     }
// }
