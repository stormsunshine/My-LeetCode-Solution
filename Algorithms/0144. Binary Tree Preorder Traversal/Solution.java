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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderTraversal = new ArrayList<Integer>();
        if (root == null)
            return preorderTraversal;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preorderTraversal.add(node.val);
            TreeNode left = node.left, right = node.right;
            if (right != null)
                stack.push(right);
            if (left != null)
                stack.push(left);
        }
        return preorderTraversal;
    }
}