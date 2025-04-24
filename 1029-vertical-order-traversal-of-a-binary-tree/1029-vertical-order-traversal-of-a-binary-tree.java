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
    // Helper class to store node value and its row index
    class NodeInfo {
        int val;
        int row;
        NodeInfo(int val, int row) {
            this.val = val;
            this.row = row;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Result list to store the final answer
        List<List<Integer>> result = new ArrayList<>();
        
        // Map to store nodes grouped by their column index (horizontal distance)
        Map<Integer, List<NodeInfo>> map = new TreeMap<>();
        
        // Queue for BFS: stores nodes along with their column and row positions
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[] { root, 0, 0 }); // root node, column 0, row 0
        
        // Perform BFS traversal
        while (!queue.isEmpty()) {
            Object[] curr = queue.poll();
            TreeNode node = (TreeNode) curr[0];
            int col = (int) curr[1];
            int row = (int) curr[2];
            
            // Add the node to the map
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(new NodeInfo(node.val, row));
            
            // Add left and right children to the queue
            if (node.left != null) {
                queue.offer(new Object[] { node.left, col - 1, row + 1 });
            }
            if (node.right != null) {
                queue.offer(new Object[] { node.right, col + 1, row + 1 });
            }
        }
        
        // Process the map to sort nodes at each column and prepare the final result
        for (List<NodeInfo> nodesAtColumn : map.values()) {
            // Sort the nodes: first by row, then by value
            Collections.sort(nodesAtColumn, (a, b) -> a.row == b.row ? a.val - b.val : a.row - b.row);
            
            // Collect the values of nodes into the result list
            List<Integer> column = new ArrayList<>();
            for (NodeInfo node : nodesAtColumn) {
                column.add(node.val);
            }
            result.add(column);
        }
        
        return result;
    }
}