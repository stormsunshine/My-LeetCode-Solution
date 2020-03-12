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
    public TreeNode increasingBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;
        List<Integer> inorderTraversal = inorderTraversal(root);
        TreeNode newRoot = new TreeNode(inorderTraversal.get(0));
        TreeNode temp = newRoot;
        int size = inorderTraversal.size();
        for (int i = 1; i < size; i++) {
            TreeNode node = new TreeNode(inorderTraversal.get(i));
            temp.right = node;
            temp = temp.right;
        }
        return newRoot;
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