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
    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;
        int leftTilt = findTilt(root.left), rightTilt = findTilt(root.right);
        int leftSum = nodeValuesSum(root.left), rightSum = nodeValuesSum(root.right);
        int rootTilt = Math.abs(leftSum - rightSum);
        return leftTilt + rightTilt + rootTilt;
    }

    public int nodeValuesSum(TreeNode root) {
        if (root == null)
            return 0;
        else
            return root.val + nodeValuesSum(root.left) + nodeValuesSum(root.right);
    }
}