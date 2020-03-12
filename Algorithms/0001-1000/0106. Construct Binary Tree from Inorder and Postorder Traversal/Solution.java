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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0)
            return null;
        int length = postorder.length;
        TreeNode root = new TreeNode(postorder[length - 1]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = length - 1;
        for (int i = length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }
}