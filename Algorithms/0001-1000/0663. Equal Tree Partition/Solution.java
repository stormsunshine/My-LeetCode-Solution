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
    public boolean checkEqualTree(TreeNode root) {
        if (root == null)
            return false;
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
            if (left != null)
                node.val += left.val;
            if (right != null)
                node.val += right.val;
        }
        int sum = root.val;
        if (sum % 2 != 0)
            return false;
        int halfSum = sum / 2;
        TreeNode rootLeft = root.left, rootRight = root.right;
        if (rootLeft != null)
            queue.offer(rootLeft);
        if (rootRight != null)
            queue.offer(rootRight);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == halfSum)
                return true;
            TreeNode left = node.left, right = node.right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        return false;
    }
}