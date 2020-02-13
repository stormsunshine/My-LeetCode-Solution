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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode node1 = root1, node2 = root2;
        boolean flag = false;
        while (!flag) {
            while (node1 != null) {
                stack1.push(node1);
                node1 = node1.left;
            }
            while (node2 != null) {
                stack2.push(node2);
                node2 = node2.right;
            }
            if (stack1.isEmpty() || stack2.isEmpty())
                break;
            TreeNode visitNode1 = stack1.peek(), visitNode2 = stack2.peek();
            int sum = visitNode1.val + visitNode2.val;
            if (sum == target)
                flag = true;
            else if (sum < target) {
                stack1.pop();
                node1 = visitNode1.right;
            } else {
                stack2.pop();
                node2 = visitNode2.left;
            }
        }
        return flag;
    }
}