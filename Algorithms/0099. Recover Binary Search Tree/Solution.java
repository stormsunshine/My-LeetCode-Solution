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
    public void recoverTree(TreeNode root) {
        TreeNode cur = root, preNew = null;
        TreeNode first = null, second = null;
        while (cur != null) {
            if (cur.left == null) {
                if (preNew != null && cur.val < preNew.val) {
                    if (first == null)
                        first = preNew;
                    second = cur;
                }
                preNew = cur;
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else if (pre.right == cur) {
                    pre.right = null;
                    if (preNew != null && cur.val < preNew.val) {
                        if (first == null)
                            first = preNew;
                        second = cur;
                    }
                    preNew = cur;
                    cur = cur.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}