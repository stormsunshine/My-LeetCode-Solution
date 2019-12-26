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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int bottomLeftValue = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            bottomLeftValue = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left, right = node.right;
                if (left != null)
                    queue.offer(left);
                if (right != null)
                    queue.offer(right);
            }
        }
        return bottomLeftValue;
    }
}