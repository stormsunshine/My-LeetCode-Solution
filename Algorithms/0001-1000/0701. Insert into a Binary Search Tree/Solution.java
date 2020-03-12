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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insert = new TreeNode(val);
        TreeNode node = root;
        while (node != null) {
            if (node.val == val)
                return node;
            else if (node.val > val) {
                if (node.left != null)
                    node = node.left;
                else {
                    node.left = insert;
                    break;
                }
            } else {
                if (node.right != null)
                    node = node.right;
                else {
                    node.right = insert;
                    break;
                }
            }
        }
        return root;
    }
}