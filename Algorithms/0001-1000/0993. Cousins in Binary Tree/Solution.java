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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || x == y)
            return false;
        TreeNode xParent = null, yParent = null;
        int xDepth = -1, yDepth = -1;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        depthQueue.offer(0);
        while (!nodeQueue.isEmpty() && (xDepth < 0 || yDepth < 0)) {
            TreeNode node = nodeQueue.poll();
            int depth = depthQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                nodeQueue.offer(left);
                depthQueue.offer(depth + 1);
                if (left.val == x) {
                    xParent = node;
                    xDepth = depth + 1;
                }
                if (left.val == y) {
                    yParent = node;
                    yDepth = depth + 1;
                }
            }
            if (right != null) {
                nodeQueue.offer(right);
                depthQueue.offer(depth + 1);
                if (right.val == x) {
                    xParent = node;
                    xDepth = depth + 1;
                }
                if (right.val == y) {
                    yParent = node;
                    yDepth = depth + 1;
                }
            }
        }
        return xDepth == yDepth && xParent != yParent;
    }
}