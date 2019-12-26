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
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return paths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int paths(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int paths = 0;
        if (root.val == sum)
            paths++;
        paths += paths(root.left, sum - root.val);
        paths += paths(root.right, sum - root.val);
        return paths;
    }
}