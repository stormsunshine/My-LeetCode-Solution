/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        int count = 1;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> maxNode = new LinkedList<Integer>();
        nodeQueue.offer(root);
        maxNode.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int max = maxNode.poll();
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                nodeQueue.offer(left);
                if (left.val >= max)
                    count++;
                maxNode.offer(Math.max(left.val, max));
            }
            if (right != null) {
                nodeQueue.offer(right);
                if (right.val >= max)
                    count++;
                maxNode.offer(Math.max(right.val, max));
            }
        }
        return count;
    }
}