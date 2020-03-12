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
    Set<Integer> set = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        prePost(root);
        for (int key : set) {
            if (set.contains(k - key) && k - key != key)
                return true;
        }
        return false;
    }

    public void prePost(TreeNode root) {
        if (root == null)
            return;
        set.add(root.val);
        prePost(root.left);
        prePost(root.right);
    }
}