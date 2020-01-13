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
    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left, right = node.right;
            node.left = right;
            node.right = left;
            if (right != null)
                queue.offer(right);
            if (left != null)
                queue.offer(left);
        }
        return root;
    }
}