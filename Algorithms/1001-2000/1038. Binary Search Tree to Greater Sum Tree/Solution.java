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
    public TreeNode bstToGst(TreeNode root) {
        if (root == null)
            return root;
        int prevVal = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            TreeNode visitNode = stack.pop();
            visitNode.val += prevVal;
            prevVal = visitNode.val;
            node = visitNode.left;
        }
        return root;
    }
}