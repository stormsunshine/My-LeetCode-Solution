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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int minDepth = Integer.MAX_VALUE;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        depthQueue.offer(1);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int depth = depthQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                nodeQueue.offer(left);
                depthQueue.offer(depth + 1);
            }
            if (right != null) {
                nodeQueue.offer(right);
                depthQueue.offer(depth + 1);
            }
            if (left == null && right == null)
                minDepth = Math.min(minDepth, depth);
        }
        return minDepth;
    }
}