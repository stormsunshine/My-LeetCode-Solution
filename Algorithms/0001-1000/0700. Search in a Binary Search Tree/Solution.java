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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            if (node.val == val)
                return node;
            else if (node.val > val)
                node = node.left;
            else
                node = node.right;
        }
        return null;
    }
}