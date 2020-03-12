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
    public int distributeCoins(TreeNode root) {
        int moves = 0;
        List<TreeNode> list = new ArrayList<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node);
            TreeNode left = node.left, right = node.right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            TreeNode node = list.get(i);
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                int leftVal = left.val;
                int difference = leftVal - 1;
                left.val -= difference;
                node.val += difference;
                moves += Math.abs(difference);
            }
            if (right != null) {
                int rightVal = right.val;
                int difference = rightVal - 1;
                right.val -= difference;
                node.val += difference;
                moves += Math.abs(difference);
            }
        }
        return moves;
    }
}