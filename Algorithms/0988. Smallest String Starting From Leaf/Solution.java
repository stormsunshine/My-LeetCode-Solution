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
    String smallestStr = "";

    public String smallestFromLeaf(TreeNode root) {
        if (root == null)
            return smallestStr;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<StringBuffer> strQueue = new LinkedList<StringBuffer>();
        nodeQueue.offer(root);
        strQueue.offer(new StringBuffer(String.valueOf((char) ('a' + root.val))));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            StringBuffer sb = strQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sb.reverse();
                String str = sb.toString();
                if (smallestStr.length() == 0 || str.compareTo(smallestStr) < 0)
                    smallestStr = str;
                sb.reverse();
            } else {
                if (left != null) {
                    StringBuffer leftSB = new StringBuffer(sb.toString());
                    leftSB.append((char) ('a' + left.val));
                    nodeQueue.offer(left);
                    strQueue.offer(leftSB);
                }
                if (right != null) {
                    StringBuffer rightSB = new StringBuffer(sb.toString());
                    rightSB.append((char) ('a' + right.val));
                    nodeQueue.offer(right);
                    strQueue.offer(rightSB);
                }
            }
        }
        return smallestStr;
    }
}