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
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        int maxSum = 0;
        int maxSumLevel = 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            level++;
            int curSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curSum += node.val;
                TreeNode left = node.left, right = node.right;
                if (left != null)
                    queue.offer(left);
                if (right != null)
                    queue.offer(right);
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                maxSumLevel = level;
            }
        }
        return maxSumLevel;
    }
}