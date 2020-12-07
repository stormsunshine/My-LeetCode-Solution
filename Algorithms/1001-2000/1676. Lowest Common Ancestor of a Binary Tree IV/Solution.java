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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null || nodes == null || nodes.length == 0)
            return null;
        Set<TreeNode> set = new HashSet<TreeNode>();
        for (TreeNode node : nodes)
            set.add(node);
        return depthFirstSearch(root, set);
    }

    public TreeNode depthFirstSearch(TreeNode root, Set<TreeNode> set) {
        if (root == null || set.contains(root))
            return root;
        TreeNode left = depthFirstSearch(root.left, set);
        TreeNode right = depthFirstSearch(root.right, set);
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }
}