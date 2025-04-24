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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean zigzag = true;

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = q.size();
            // traversing one level
            for(int i = 0; i < n; i++){
                root = q.poll();
                if(root.left!=null) q.add(root.left);
                if(root.right!=null) q.add(root.right);
                level.add(root.val);
            }
            if(!zigzag){
                    Collections.reverse(level);
                }
            result.add(level);
            zigzag = !zigzag;
        }
        return result;
        // List<List<Integer>> result = new ArrayList<>();
        // if(root == null) return result;

        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        // boolean zigzag = true;

        // while(!q.isEmpty()){
        //     List<Integer> level = new ArrayList<>();
        //     int n = q.size();
        //     // traversing one level
        //     for(int i = 0; i < n; i++){
        //         root = q.poll();
        //         if(root.left!=null) q.add(root.left);
        //         if(root.right!=null) q.add(root.right);
        //         if(zigzag){
        //             level.add(root.val);
        //         }else{
        //             level.add(0, root.val);
        //         }
        //     }
        //     result.add(level);
        //     zigzag = !zigzag;
        // }
        // return result;
    }
}