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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode mergeRoot = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue.offer(mergeRoot);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left;
            TreeNode right1 = node1.right, right2 = node2.right;
            if (left1 != null && left2 != null) {
                TreeNode mergeLeft = new TreeNode(left1.val + left2.val);
                node.left = mergeLeft;
                queue.offer(mergeLeft);
                queue1.offer(left1);
                queue2.offer(left2);
            } else if (left1 != null) {
                TreeNode mergeLeft = new TreeNode(left1.val);
                node.left = mergeLeft;
                queue.offer(mergeLeft);
                queue1.offer(left1);
                queue2.offer(new TreeNode(0));
            } else if (left2 != null) {
                TreeNode mergeLeft = new TreeNode(left2.val);
                node.left = mergeLeft;
                queue.offer(mergeLeft);
                queue1.offer(new TreeNode(0));
                queue2.offer(left2);
            }
            if (right1 != null && right2 != null) {
                TreeNode mergeRight = new TreeNode(right1.val + right2.val);
                node.right = mergeRight;
                queue.offer(mergeRight);
                queue1.offer(right1);
                queue2.offer(right2);
            } else if (right1 != null) {
                TreeNode mergeRight = new TreeNode(right1.val);
                node.right = mergeRight;
                queue.offer(mergeRight);
                queue1.offer(right1);
                queue2.offer(new TreeNode(0));
            } else if (right2 != null) {
                TreeNode mergeRight = new TreeNode(right2.val);
                node.right = mergeRight;
                queue.offer(mergeRight);
                queue1.offer(new TreeNode(0));
                queue2.offer(right2);
            }
        }
        return mergeRoot;
    }
}