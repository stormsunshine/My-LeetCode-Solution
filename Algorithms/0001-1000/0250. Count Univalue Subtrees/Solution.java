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
    public int countUnivalSubtrees(TreeNode root) {
        int[] array = helper(root);
        return array[0];
    }

    public int[] helper(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        if (root.left == null && root.right == null)
            return new int[]{1, 1};
        else if (root.left == null) {
            int[] rightArray = helper(root.right);
            int rightCount = rightArray[0];
            if (rightArray[1] == 0 || root.val != root.right.val)
                return new int[]{rightCount, 0};
            else
                return new int[]{rightCount + 1, 1};
        } else if (root.right == null) {
            int[] leftArray = helper(root.left);
            int leftCount = leftArray[0];
            if (leftArray[1] == 0 || root.val != root.left.val)
                return new int[]{leftCount, 0};
            else
                return new int[]{leftCount + 1, 1};
        } else {
            int[] leftArray = helper(root.left);
            int[] rightArray = helper(root.right);
            int leftCount = leftArray[0], rightCount = rightArray[0];
            if (leftArray[1] == 0 || rightArray[1] == 0 || root.val != root.left.val || root.val != root.right.val)
                return new int[]{leftCount + rightCount, 0};
            else
                return new int[]{leftCount + rightCount + 1, 1};
        }
    }
}