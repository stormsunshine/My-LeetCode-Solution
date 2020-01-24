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
    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;
        Map<TreeNode, int[]> nodeLengthsMap = new HashMap<TreeNode, int[]>();
        List<TreeNode> nodesList = new ArrayList<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodesList.add(node);
            nodeLengthsMap.put(node, new int[]{0, 0});
            TreeNode left = node.left, right = node.right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        int maxLength = 1;
        int size = nodesList.size();
        for (int i = size - 1; i >= 0; i--) {
            TreeNode node = nodesList.get(i);
            int val = node.val;
            int[] curLengths = new int[2];
            curLengths[0] = 0;
            curLengths[1] = 0;
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null)
                continue;
            else if (right == null) {
                int leftVal = left.val;
                int[] leftLengths = nodeLengthsMap.get(left);
                if (val - leftVal == 1)
                    curLengths[0] = Math.max(0, Math.max(leftLengths[0], leftLengths[1])) + 1;
                else if (val - leftVal == -1)
                    curLengths[0] = Math.min(0, Math.min(leftLengths[0], leftLengths[1])) - 1;
                maxLength = Math.max(maxLength, Math.abs(curLengths[0]) + 1);
            } else if (left == null) {
                int rightVal = right.val;
                int[] rightLengths = nodeLengthsMap.get(right);
                if (val - rightVal == 1)
                    curLengths[1] = Math.max(0, Math.max(rightLengths[0], rightLengths[1])) + 1;
                else if (val - rightVal == -1)
                    curLengths[1] = Math.min(0, Math.min(rightLengths[0], rightLengths[1])) - 1;
                maxLength = Math.max(maxLength, Math.abs(curLengths[1]) + 1);
            } else {
                int leftVal = left.val;
                int rightVal = right.val;
                int[] leftLengths = nodeLengthsMap.get(left);
                int[] rightLengths = nodeLengthsMap.get(right);
                if (val - leftVal == 1)
                    curLengths[0] = Math.max(0, Math.max(leftLengths[0], leftLengths[1])) + 1;
                else if (val - leftVal == -1)
                    curLengths[0] = Math.min(0, Math.min(leftLengths[0], leftLengths[1])) - 1;
                if (val - rightVal == 1)
                    curLengths[1] = Math.max(0, Math.max(rightLengths[0], rightLengths[1])) + 1;
                else if (val - rightVal == -1)
                    curLengths[1] = Math.min(0, Math.min(rightLengths[0], rightLengths[1])) - 1;
                if (curLengths[0] * curLengths[1] < 0)
                    maxLength = Math.max(maxLength, Math.abs(curLengths[0] - curLengths[1]) + 1);
                else
                    maxLength = Math.max(maxLength, Math.max(Math.abs(curLengths[0]), Math.abs(curLengths[1])) + 1);
            }
            nodeLengthsMap.put(node, curLengths);
        }
        return maxLength;
    }
}