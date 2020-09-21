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
class BSTIterator {
    TreeNode dummyHead = new TreeNode(0);
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = dummyHead, node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                TreeNode visitNode = new TreeNode(node.val);
                prev.right = visitNode;
                visitNode.left = prev;
                prev = visitNode;
                node = node.right;
            }
        }
        curr = dummyHead;
    }
    
    public boolean hasNext() {
        return curr.right != null;
    }
    
    public int next() {
        curr = curr.right;
        return curr.val;
    }
    
    public boolean hasPrev() {
        return curr.left != dummyHead && curr != dummyHead;
    }
    
    public int prev() {
        curr = curr.left;
        return curr.val;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */