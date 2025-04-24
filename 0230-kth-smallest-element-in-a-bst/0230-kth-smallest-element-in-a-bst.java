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
    int count = 0;
    int result = -1;

    public int helper(TreeNode root, int k) {
        if (root == null) return -1;

        helper(root.left, k);

        count++;
        if (count == k) {
            result = root.val;
            return result;
        }

        helper(root.right, k);

        return result;
    }

    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k);
    }
}



//  1st method--Approach 2: save only k elements
// class Solution {

//     ArrayList<Integer> result = new ArrayList<>();

//     public void helper(TreeNode root, int k){
//         if(root == null) return;
//         if(result.size() == k) return;

//         helper(root.left, k);
//         if(result.size() == k) return;
//         result.add(root.val);
//         if(result.size() == k) return;
//         helper(root.right, k);
//     }
//     public int kthSmallest(TreeNode root, int k) {
//         helper(root, k);
//         return result.get(k - 1);
//     }
// }
//  2nd method
//  class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         // Use a stack to simulate in-order traversal
//         Stack<TreeNode> stack = new Stack<>();
        
//         while (root != null || !stack.isEmpty()) {
//             // Go to the leftmost node
//             while (root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop(); // Visit the node
//             k--;
//             if (k == 0) return root.val; // Found the kth node
//             root = root.right; // Move to right subtree
//         }
        
//         return -1; // This shouldn't be reached if k is valid
//     }
// }