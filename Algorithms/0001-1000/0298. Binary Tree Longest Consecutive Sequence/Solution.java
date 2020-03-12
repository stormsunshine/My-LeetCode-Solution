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
    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;
        int maxLength = 1;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> lengthQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        lengthQueue.offer(1);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int length = lengthQueue.poll();
            maxLength = Math.max(maxLength, length);
            int nodeVal = node.val;
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                int leftVal = left.val;
                int leftLength = leftVal - nodeVal == 1 ? length + 1 : 1;
                nodeQueue.offer(left);
                lengthQueue.offer(leftLength);
            }
            if (right != null) {
                int rightVal = right.val;
                int rightLength = rightVal - nodeVal == 1 ? length + 1 : 1;
                nodeQueue.offer(right);
                lengthQueue.offer(rightLength);
            }
        }
        return maxLength;
    }
}