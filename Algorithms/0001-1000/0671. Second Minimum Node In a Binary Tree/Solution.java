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
    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int value = node.val;
            if (!values.contains(value))
                values.add(value);
            TreeNode left = node.left, right = node.right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        Collections.sort(values);
        if (values.size() < 2)
            return -1;
        else
            return values.get(1);
    }
}