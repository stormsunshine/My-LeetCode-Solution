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
    public int closestValue(TreeNode root, double target) {
        int closestValue = root.val;
        double minDifference = Math.abs(closestValue - target);
        TreeNode temp = root;
        while (temp != null) {
            int value = temp.val;
            if (value == target)
                return value;
            else {
                double difference = Math.abs(value - target);
                if (difference < minDifference) {
                    closestValue = value;
                    minDifference = difference;
                }
                if (value > target)
                    temp = temp.left;
                else
                    temp = temp.right;
            }
        }
        return closestValue;
    }
}