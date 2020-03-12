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
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderTraversal = inorderTraversal(root);
        int size = inorderTraversal.size();
        for (int i = 1; i < size; i++) {
            if (inorderTraversal.get(i) <= inorderTraversal.get(i - 1))
                return false;
        }
        return true;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderTraversal = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode visitNode = stack.pop();
            inorderTraversal.add(visitNode.val);
            node = visitNode.right;
        }
        return inorderTraversal;
    }
}