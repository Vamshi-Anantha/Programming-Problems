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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // Search for the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to be deleted found

            // Case 1: No left child
            if (root.left == null) return root.right;

            // Case 2: No right child
            if (root.right == null) return root.left;

            // Case 3: Two children - Get inorder successor (smallest in right subtree)
            TreeNode successor = getSuccessor(root);
            root.val = successor.val; // Replace value
            root.right = deleteNode(root.right, successor.val); // Delete successor
        }
        return root;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode curr = node.right;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
