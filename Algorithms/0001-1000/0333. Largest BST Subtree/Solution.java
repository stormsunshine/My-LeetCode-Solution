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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        List<TreeNode> list = new ArrayList<TreeNode>();
        Map<TreeNode, int[]> map = new HashMap<TreeNode, int[]>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int[] bstArray = {node.val, node.val, 0, 0};
            list.add(node);
            map.put(node, bstArray);
            TreeNode left = node.left, right = node.right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        int largestBST = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            TreeNode node = list.get(i);
            int[] bstArray = map.getOrDefault(node, new int[]{node.val, node.val, 0, 0});
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                bstArray[2] = 1;
                bstArray[3] = 1;
                map.put(node, bstArray);
                largestBST = Math.max(largestBST, 1);
            } else if (right == null) {
                int[] leftBstArray = map.getOrDefault(left, new int[]{left.val, left.val, 0, 0});
                if (leftBstArray[2] == 1 && leftBstArray[1] < node.val) {
                    bstArray[0] = leftBstArray[0];
                    bstArray[2] = 1;
                    bstArray[3] = leftBstArray[3] + 1;
                    map.put(node, bstArray);
                    largestBST = Math.max(largestBST, bstArray[3]);
                }
            } else if (left == null) {
                int[] rightBstArray = map.getOrDefault(right, new int[]{right.val, right.val, 0, 0});
                if (rightBstArray[2] == 1 && rightBstArray[0] > node.val) {
                    bstArray[1] = rightBstArray[1];
                    bstArray[2] = 1;
                    bstArray[3] = rightBstArray[3] + 1;
                    map.put(node, bstArray);
                    largestBST = Math.max(largestBST, bstArray[3]);
                }
            } else {
                int[] leftBstArray = map.getOrDefault(left, new int[]{left.val, left.val, 0, 0});
                int[] rightBstArray = map.getOrDefault(right, new int[]{right.val, right.val, 0, 0});
                if (leftBstArray[2] == 1 && rightBstArray[2] == 1 && leftBstArray[1] < node.val && rightBstArray[0] > node.val) {
                    bstArray[0] = leftBstArray[0];
                    bstArray[1] = rightBstArray[1];
                    bstArray[2] = 1;
                    bstArray[3] = leftBstArray[3] + rightBstArray[3] + 1;
                    map.put(node, bstArray);
                    largestBST = Math.max(largestBST, bstArray[3]);
                }
            }
        }
        return largestBST;
    }
}