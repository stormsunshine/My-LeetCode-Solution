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
    public int maxAncestorDiff(TreeNode root) {
        Map<TreeNode, int[]> nodeValuesMap = new HashMap<TreeNode, int[]>();
        List<TreeNode> nodesList = new ArrayList<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int value = node.val;
            nodesList.add(node);
            nodeValuesMap.put(node, new int[]{value, value});
            TreeNode left = node.left, right = node.right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        int maxDifference = 0;
        for (int i = nodesList.size() - 1; i >= 0; i--) {
            TreeNode node = nodesList.get(i);
            int value = node.val;
            int[] values = nodeValuesMap.get(node);
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                int[] leftValues = nodeValuesMap.get(left);
                maxDifference = Math.max(maxDifference, Math.max(Math.abs(value - leftValues[0]), Math.abs(value - leftValues[1])));
                values[0] = Math.min(values[0], leftValues[0]);
                values[1] = Math.max(values[1], leftValues[1]);
            }
            if (right != null) {
                int[] rightValues = nodeValuesMap.get(right);
                maxDifference = Math.max(maxDifference, Math.max(Math.abs(value - rightValues[0]), Math.abs(value - rightValues[1])));
                values[0] = Math.min(values[0], rightValues[0]);
                values[1] = Math.max(values[1], rightValues[1]);
            }
        }
        return maxDifference;
    }
}