/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null || root.val != arr[0])
            return false;
        int length = arr.length;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int index = 0;
        while (index < length && !queue.isEmpty()) {
            int num = arr[index];
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == num) {
                    TreeNode left = node.left, right = node.right;
                    if (left != null)
                        queue.offer(left);
                    if (right != null)
                        queue.offer(right);
                    if (index == length - 1 && left == null && right == null)
                        return true;
                }
            }
            index++;
        }
        return false;
    }
}