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
    public double maximumAverageSubtree(TreeNode root) {
        List<TreeNode> valueList = new ArrayList<TreeNode>();
        List<TreeNode> countList = new ArrayList<TreeNode>();
        Queue<TreeNode> valueQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> countQueue = new LinkedList<TreeNode>();
        valueQueue.offer(root);
        countQueue.offer(new TreeNode(1));
        while (!valueQueue.isEmpty()) {
            TreeNode valueNode = valueQueue.poll();
            TreeNode countNode = countQueue.poll();
            valueList.add(valueNode);
            countList.add(countNode);
            TreeNode left = valueNode.left;
            TreeNode right = valueNode.right;
            if (left != null) {
                countNode.left = new TreeNode(1);
                valueQueue.add(left);
                countQueue.add(countNode.left);
            }
            if (right != null) {
                countNode.right = new TreeNode(1);
                valueQueue.add(right);
                countQueue.add(countNode.right);
            }
        }
        double maxAverage = 0;
        int size = valueList.size();
        for (int i = size - 1; i >= 0; i--) {
            TreeNode valueNode = valueList.get(i);
            TreeNode countNode = countList.get(i);
            TreeNode valueLeft = valueNode.left, valueRight = valueNode.right;
            TreeNode countLeft = countNode.left, countRight = countNode.right;
            if (valueLeft != null) {
                valueNode.val += valueLeft.val;
                countNode.val += countLeft.val;
            }
            if (valueRight != null) {
                valueNode.val += valueRight.val;
                countNode.val += countRight.val;
            }
            valueList.set(i, valueNode);
            countList.set(i, countNode);
            double average = 1.0 * valueNode.val / countNode.val;
            maxAverage = Math.max(maxAverage, average);
        }
        return maxAverage;
    }
}