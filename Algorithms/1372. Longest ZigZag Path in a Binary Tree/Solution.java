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
    public int longestZigZag(TreeNode root) {
        Map<TreeNode, int[]> map = new HashMap<TreeNode, int[]>();
        map.put(root, new int[]{0, 0});
        int maxLength = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int[] lengths = map.get(node);
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                int[] leftLengths = new int[2];
                leftLengths[0] = lengths[1] + 1;
                maxLength = Math.max(maxLength, leftLengths[0]);
                map.put(left, leftLengths);
                queue.offer(left);
            }
            if (right != null) {
                int[] rightLengths = new int[2];
                rightLengths[1] = lengths[0] + 1;
                maxLength = Math.max(maxLength, rightLengths[1]);
                map.put(right, rightLengths);
                queue.offer(right);
            }
        }
        return maxLength;
    }
}