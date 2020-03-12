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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
             return 0;
        maxSinglePathSum(root);
        return max;
    }

    public int maxSinglePathSum(TreeNode root) {
        if (root == null)
            return 0;
        int value = root.val;
        int leftMax = 0, rightMax = 0;
        if (root.left != null) {
            leftMax = maxSinglePathSum(root.left);
            if (leftMax > 0)
                value += leftMax;
        }
        if (root.right != null) {
            rightMax = maxSinglePathSum(root.right);
            if (rightMax > 0)
                value += rightMax;
        }
        max = Math.max(max, value);
        return Math.max(root.val, Math.max(root.val + leftMax, root.val + rightMax));
    }
}