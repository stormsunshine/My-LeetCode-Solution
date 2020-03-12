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
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        List<TreeNode> inorderTraversal = inorderTraversal(root);
        int size = inorderTraversal.size();
        TreeNode prevNode = inorderTraversal.get(size - 1);
        for (int i = size - 2; i >= 0; i--) {
            TreeNode node = inorderTraversal.get(i);
            node.val += prevNode.val;
            prevNode = node;
        }
        return root;
    }

    public List<TreeNode> inorderTraversal(TreeNode root) {
        List<TreeNode> inorderTraversal = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode visitNode = stack.pop();
            inorderTraversal.add(visitNode);
            node = visitNode.right;
        }
        return inorderTraversal;
    }
}