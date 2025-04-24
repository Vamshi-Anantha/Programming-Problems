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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 1st method
        List<List<Integer>> result = new LinkedList<>();  // Correct return type
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            // Add level at the beginning to reverse order
            result.add(0, level);
        }

        return result;
        // 2nd method
        // List<List<Integer>> result = new LinkedList<>();
        // if (root == null) return result;

        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while (!q.isEmpty()) {
        //     List<Integer> level = new ArrayList<>();
        //     int size = q.size();

        //     for (int i = 0; i < size; i++) {
        //         TreeNode node = q.poll();
        //         level.add(node.val);

        //         // Correct order: left first, then right
        //         if (node.left != null) q.add(node.left);
        //         if (node.right != null) q.add(node.right);
        //     }

        //     // Add at the beginning of the list to reverse the order
        //     result.add(0, level);
        // }

        // return result;
    }
}
