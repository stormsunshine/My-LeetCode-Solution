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
    public int minDiffInBST(TreeNode root) {
        List<Integer> inorderTraversal = inorderTraversal(root);
        int minDiff = Integer.MAX_VALUE;
        int size = inorderTraversal.size();
        for (int i = 1; i < size; i++) {
            int diff = inorderTraversal.get(i) - inorderTraversal.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
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