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
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if (Math.abs(right - left) > 1)
            res = false;
        return Math.max(left, right);
    }
}