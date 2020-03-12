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
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        List<TreeNode> nodesList = new ArrayList<TreeNode>();
        Map<TreeNode, int[]> map = new HashMap<TreeNode, int[]>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodesList.add(node);
            map.put(node, new int[]{0, 0});
            TreeNode left = node.left, right = node.right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        int max = 0;
        int size = nodesList.size();
        for (int i = size - 1; i >= 0; i--) {
            TreeNode node = nodesList.get(i);
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null)
                map.put(node, new int[]{0, node.val});
            else if (right == null) {
                int[] dpLeft = map.getOrDefault(left, new int[]{0, 0});
                int[] dp = {Math.max(dpLeft[0], dpLeft[1]), dpLeft[0] + node.val};
                map.put(node, dp);
            } else if (left == null) {
                int[] dpRight = map.getOrDefault(right, new int[]{0, 0});
                int[] dp = {Math.max(dpRight[0], dpRight[1]), dpRight[0] + node.val};
                map.put(node, dp);
            } else {
                int[] dpLeft = map.getOrDefault(left, new int[]{0, 0});
                int[] dpRight = map.getOrDefault(right, new int[]{0, 0});
                int[] dp = {Math.max(dpLeft[0], dpLeft[1]) + Math.max(dpRight[0], dpRight[1]), dpLeft[0] + dpRight[0] + node.val};
                map.put(node, dp);
            }
        }
        int[] dpRoot = map.getOrDefault(root, new int[]{0, 0});
        return Math.max(dpRoot[0], dpRoot[1]);
    }
}