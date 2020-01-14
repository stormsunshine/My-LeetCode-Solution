/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode successor = p.right;
            while (successor.left != null)
                successor = successor.left;
            return successor;
        } else {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode parent = root;
            stack.push(parent);
            while (parent.left != p && parent.right != p) {
                if (parent.val > p.val)
                    parent = parent.left;
                else if (parent.val < p.val)
                    parent = parent.right;
                else
                    return null;
                stack.push(parent);
            }
            while (!stack.isEmpty() && stack.peek().val < p.val)
                stack.pop();
            if (!stack.isEmpty())
                return stack.peek();
            else
                return null;
        }
    }
}