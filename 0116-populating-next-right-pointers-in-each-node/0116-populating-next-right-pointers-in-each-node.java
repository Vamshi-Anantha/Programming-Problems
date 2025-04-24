/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            
            for (int i = 0; i < n; i++) {
                Node current = q.poll(); // Corrected pop() to poll()

                // Connect the current node to the next node in queue (if not last in level)
                if (i < n - 1) {
                    current.next = q.peek();
                } else {
                    current.next = null; // Last node in the level
                }

                // Add left and right children
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
        }
        return root; // Correct return statement
    }
}