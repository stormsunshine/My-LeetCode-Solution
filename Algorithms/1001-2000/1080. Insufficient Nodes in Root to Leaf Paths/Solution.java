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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean rootRemain = depthFirstSearch(root, 0, limit);
        return rootRemain ? root : null;
    }

    private boolean depthFirstSearch(TreeNode node, int sum, int limit) {
        if (node.left == null && node.right == null)
            return sum + node.val >= limit;
        boolean leftRemain = false;
        boolean rightRemain = false;
        if (node.left != null)
            leftRemain = depthFirstSearch(node.left, sum + node.val, limit);
        if (node.right != null)
            rightRemain = depthFirstSearch(node.right, sum + node.val, limit);
        if (!leftRemain)
            node.left = null;
        if (!rightRemain)
            node.right = null;
        return leftRemain || rightRemain;
    }
}