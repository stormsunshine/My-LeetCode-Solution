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
    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Boolean> booleanQueue = new LinkedList<Boolean>();
        nodeQueue.offer(root);
        booleanQueue.offer(false);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            boolean isEven = booleanQueue.poll();
            boolean curEven = node.val % 2 == 0;
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                if (isEven)
                    sum += left.val;
                nodeQueue.offer(left);
                booleanQueue.offer(curEven);
            }
            if (right != null) {
                if (isEven)
                    sum += right.val;
                nodeQueue.offer(right);
                booleanQueue.offer(curEven);
            }
        }
        return sum;
    }
}