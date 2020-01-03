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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val, qVal = q.val;
        TreeNode node = root;
        while (node != null) {
            int val = node.val;
            if (p.val < val && q.val < val)
                node = node.left;
            else if (p.val > val && q.val > val)
                node = node.right;
            else
                break;
        }
        return node;
    }
}