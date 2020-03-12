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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        TreeNode newRoot = stack.pop();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode prevLeft = node.left, prevRight = node.right;
            prevLeft.left = prevRight;
            prevLeft.right = node;
            if (prevRight != null) {
                prevRight.left = null;
                prevRight.right = null;
            }
            node.left = null;
            node.right = null;
        }
        return newRoot;
    }
}