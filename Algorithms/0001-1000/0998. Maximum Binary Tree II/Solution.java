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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null)
            return newNode;
        if (val > root.val) {
            newNode.left = root;
            return newNode;
        }
        TreeNode temp = root;
        while (temp.val > val) {
            TreeNode rightChild = temp.right;
            if (rightChild == null) {
                temp.right = newNode;
                break;
            } else if (rightChild.val < val) {
                temp.right = newNode;
                newNode.left = rightChild;
                break;
            } else
                temp = temp.right;
        }
        return root;
    }
}