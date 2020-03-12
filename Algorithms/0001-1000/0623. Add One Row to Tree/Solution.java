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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null)
            return root;
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 2;
        while (!queue.isEmpty() && level < d) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left, right = node.right;
                if (left != null)
                    queue.offer(left);
                if (right != null)
                    queue.offer(right);
            }
            level++;
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left, right = node.right;
            node.left = new TreeNode(v);
            node.left.left = left;
            node.right = new TreeNode(v);
            node.right.right = right;
        }
        return root;
    }
}