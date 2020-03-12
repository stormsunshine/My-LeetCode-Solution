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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValues = new ArrayList<Integer>();
        if (root == null)
            return largestValues;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curLargest = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curLargest = Math.max(curLargest, node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null)
                    queue.offer(left);
                if (right != null)
                    queue.offer(right);
            }
            largestValues.add(curLargest);
        }
        return largestValues;
    }
}