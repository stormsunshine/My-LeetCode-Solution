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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null ^ root2 == null)
            return false;
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty()) {
            if (queue2.isEmpty())
                return false;
            TreeNode node1 = queue1.poll(), node2 = queue2.poll();
            if (node1.val != node2.val)
                return false;
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null && right1 == null) {
                if (left2 != null || right2 != null)
                    return false;
            } else {
                if (left1 == null) {
                    left1 = right1;
                    right1 = null;
                }
                if (left2 == null) {
                    left2 = right2;
                    right2 = null;
                }
                if (left1 == null ^ left2 == null)
                    return false;
                if (right1 == null ^ right2 == null)
                    return false;
                if (right1 == null && left1.val != left2.val)
                    return false;
                if (left1 != null && right1 != null) {
                    if (left1.val == right2.val) {
                        TreeNode temp = left2;
                        left2 = right2;
                        right2 = temp;
                    }
                }
                if (left1 != null)
                    queue1.offer(left1);
                if (right1 != null)
                    queue1.offer(right1);
                if (left2 != null)
                    queue2.offer(left2);
                if (right2 != null)
                    queue2.offer(right2);
            }
        }
        return queue2.isEmpty();
    }
}