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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> lonelyNodes = new ArrayList<Integer>();
        if (root == null)
            return lonelyNodes;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left, right = node.right;
            if (left != null && right != null) {
                queue.offer(left);
                queue.offer(right);
            } else if (left != null) {
                lonelyNodes.add(left.val);
                queue.offer(left);
            } else if (right != null) {
                lonelyNodes.add(right.val);
                queue.offer(right);
            }
        }
        return lonelyNodes;
    }
}