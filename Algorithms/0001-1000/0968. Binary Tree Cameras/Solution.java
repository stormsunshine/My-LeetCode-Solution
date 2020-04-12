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
    public int minCameraCover(TreeNode root) {
        if (root == null)
            return 0;
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
        Map<TreeNode, int[]> map = new HashMap<TreeNode, int[]>();
        for (int i = list.size() - 1; i >= 0; i--) {
            TreeNode node = list.get(i);
            if (node.left == null && node.right == null)
                map.put(node, new int[]{0, Integer.MAX_VALUE / 10, 1});
            else if (node.left == null) {
                int[] rightArray = map.get(node.right);
                int[] array = new int[3];
                array[0] = rightArray[1];
                array[1] = rightArray[2];
                array[2] = 1 + Math.min(rightArray[0], Math.min(rightArray[1], rightArray[2]));
                map.put(node, array);
            } else if (node.right == null) {
                int[] leftArray = map.get(node.left);
                int[] array = new int[3];
                array[0] = leftArray[1];
                array[1] = leftArray[2];
                array[2] = 1 + Math.min(leftArray[0], Math.min(leftArray[1], leftArray[2]));
                map.put(node, array);
            } else {
                int[] leftArray = map.get(node.left);
                int[] rightArray = map.get(node.right);
                int minLeft = Math.min(leftArray[1], leftArray[2]);
                int minRight = Math.min(rightArray[1], rightArray[2]);
                int[] array = new int[3];
                array[0] = leftArray[1] + rightArray[1];
                array[1] = Math.min(leftArray[2] + minRight, rightArray[2] + minLeft);
                array[2] = 1 + Math.min(leftArray[0], minLeft) + Math.min(rightArray[0], minRight);
                map.put(node, array);
            }
        }
        int[] rootArray = map.get(root);
        return Math.min(rootArray[1], rootArray[2]);
    }
}