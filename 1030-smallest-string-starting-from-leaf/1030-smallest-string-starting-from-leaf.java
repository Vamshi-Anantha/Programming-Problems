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
    String smallest = "~";  // "~" is lexicographically larger than any lowercase letter string

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }
    
    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) return;

        // Add current character to the path (at the front because we want from leaf to root)
        path.insert(0, (char)(node.val + 'a'));

        // If it's a leaf, check if this path is smaller
        if (node.left == null && node.right == null) {
            String current = path.toString();
            if (current.compareTo(smallest) < 0) {
                smallest = current;
            }
        }

        // Recurse to left and right
        dfs(node.left, path);
        dfs(node.right, path);

        // Backtrack: remove the character we added
        path.deleteCharAt(0);
    }
}
