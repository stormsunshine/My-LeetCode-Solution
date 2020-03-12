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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (root.left == null ^ root.right == null)
            return false;
        TreeNode left = root.left, right = root.right;
        if (left.val != right.val)
            return false;
        Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
        leftQueue.offer(left);
        rightQueue.offer(right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftNode = leftQueue.poll(), rightNode = rightQueue.poll();
            if (leftNode.val != rightNode.val)
                return false;
            TreeNode leftLeft = leftNode.left, leftRight = leftNode.right;
            TreeNode rightRight = rightNode.right, rightLeft = rightNode.left;
            if (leftLeft == null ^ rightRight == null)
                return false;
            if (leftRight == null ^ rightLeft == null)
                return false;
            if (leftLeft != null)
                leftQueue.offer(leftLeft);
            if (leftRight != null)
                leftQueue.offer(leftRight);
            if (rightRight != null)
                rightQueue.offer(rightRight);
            if (rightLeft != null)
                rightQueue.offer(rightLeft);
        }
        if (leftQueue.isEmpty() ^ rightQueue.isEmpty())
            return false;
        return true;
    }
}