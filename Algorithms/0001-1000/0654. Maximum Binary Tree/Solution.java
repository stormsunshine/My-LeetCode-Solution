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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            TreeNode node = new TreeNode(num);
            TreeNode temp = null;
            while (!stack.isEmpty() && stack.peek().val < num)
                temp = stack.pop();
            if (!stack.isEmpty())
                stack.peek().right = node;
            stack.push(node);
            node.left = temp;
        }
        TreeNode root = null;
        while (!stack.isEmpty())
            root = stack.pop();
        return root;
    }
}