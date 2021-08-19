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
    int count = 0;

    public int equalToDescendants(TreeNode root) {
        getSum(root);
        return count;
    }

    public int getSum(TreeNode root) {
        if (root == null)
            return 0;
        int childrenSum = getSum(root.left) + getSum(root.right);
        if (childrenSum == root.val)
            count++;
        return childrenSum + root.val;
    }
}