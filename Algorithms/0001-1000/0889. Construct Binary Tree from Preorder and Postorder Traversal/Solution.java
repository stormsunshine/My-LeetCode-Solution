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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int length = pre.length;
        if (length == 0)
            return null;
        else if (length == 1)
            return new TreeNode(pre[0]);
        else {
            TreeNode root = new TreeNode(pre[0]);
            int leftChild = pre[1];
            int leftCount = 0;
            for (int i = 0; i < length; i++) {
                if (post[i] == leftChild) {
                    leftCount = i + 1;
                    break;
                }
            }
            root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, 1 + leftCount), Arrays.copyOfRange(post, 0, leftCount));
            root.right = constructFromPrePost(Arrays.copyOfRange(pre, 1 + leftCount, length), Arrays.copyOfRange(post, leftCount, length - 1));
            return root;
        }
    }
}