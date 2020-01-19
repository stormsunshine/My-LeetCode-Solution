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
    int path;

    public int diameterOfBinaryTree(TreeNode root) {
        path = 1;
        depthFirstSearch(root);
        return path - 1;        
    }

    public int depthFirstSearch(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = depthFirstSearch(node.left);
        int rightDepth = depthFirstSearch(node.right);
        path = Math.max(path, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}