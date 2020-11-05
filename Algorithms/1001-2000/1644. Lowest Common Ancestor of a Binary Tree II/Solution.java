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
    public TreeNode ancestor = null;
    public TreeNode p = null, q = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNodes(root, p, q);
        if (p == null || q == null)
            return null;
        depthFirstSearch(root, p, q);
        return ancestor;
    }

    public void findNodes(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return;
        if (root == p)
            this.p = p;
        else if (root == q)
            this.q = q;
        findNodes(root.left, p, q);
        findNodes(root.right, p, q);
    }

    public boolean depthFirstSearch(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        boolean left = depthFirstSearch(root.left, p, q);
        boolean right = depthFirstSearch(root.right, p, q);
        if (left && right || ((root.val == p.val || root.val == q.val) && (left || right)))
            ancestor = root;
        return left || right || (root.val == p.val || root.val == q.val);
    }
}