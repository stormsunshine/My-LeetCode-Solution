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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        while (root != null && root.val < L)
            root = root.right;
        if (root == null)
            return null;
        TreeNode parentLeft = root, childLeft = root.left;
        while (childLeft != null) {
            if (childLeft.val < L) {
                parentLeft.left = childLeft.right;
                childLeft = childLeft.right;
            } else {
                parentLeft = childLeft;
                childLeft = childLeft.left;
            }
        }
        while (root != null && root.val > R)
            root = root.left;
        if (root == null)
            return null;
        TreeNode parentRight = root, childRight = root.right;
        while (childRight != null) {
            if (childRight.val > R) {
                parentRight.right = childRight.left;
                childRight = childRight.left;
            } else {
                parentRight = childRight;
                childRight = childRight.right;
            }
        }
        return root;
    }
}