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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int half = n / 2;
        if (root.val == x) {
            TreeNode left = root.left, right = root.right;
            if (left == null || right == null)
                return true;
            int count = countNodes(left);
            if (count == half)
                return false;
            else
                return true;
        } else {
            TreeNode xNode = null;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.val == x) {
                    xNode = node;
                    break;
                } else {
                    TreeNode left = node.left, right = node.right;
                    if (left != null)
                        queue.offer(left);
                    if (right != null)
                        queue.offer(right);
                }
            }
            int leftCount = 0, rightCount = 0;
            TreeNode xLeft = xNode.left, xRight = xNode.right;
            if (xLeft != null)
                leftCount = countNodes(xLeft);
            if (xRight != null)
                rightCount = countNodes(xRight);
            int remainCount = n - 1 - leftCount - rightCount;
            if (leftCount > half || rightCount > half || remainCount > half)
                return true;
            else
                return false;
        }
    }

    public int countNodes(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;
            TreeNode left = node.left, right = node.right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        return count;
    }
}