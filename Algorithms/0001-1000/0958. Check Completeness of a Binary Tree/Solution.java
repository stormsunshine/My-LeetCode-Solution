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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int levelNodes = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size == levelNodes) {
                boolean flag = true;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    TreeNode left = node.left, right = node.right;
                    if (left == null && right != null)
                        return false;
                    if (left != null)
                        queue.offer(left);
                    if (right != null)
                        queue.offer(right);
                    if (!flag && (left != null || right != null))
                        return false;
                    if (flag && (left == null || right == null))
                        flag = false;
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null || node.right != null)
                        return false;
                }
            }
            levelNodes <<= 1;
        }
        return true;
    }
}