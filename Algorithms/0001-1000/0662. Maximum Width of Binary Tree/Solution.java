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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int maxWidth = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            int leftmost = -1, rightmost = -1;
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                int num = numQueue.poll();
                if (leftmost < 0)
                    leftmost = num;
                rightmost = num;
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 2 + 1);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 2 + 2);
                }
            }
            int width = rightmost - leftmost + 1;
            maxWidth = Math.max(maxWidth, width);
        }
        return maxWidth;
    }
}