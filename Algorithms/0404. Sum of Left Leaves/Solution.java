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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left, right = node.right;
            if (isLeaf(left))
                sum += left.val;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        return sum;
    }

    public boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;
        return false;
    }
}