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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        else
            return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if (start > end)
            trees.add(null);
        else {
            for (int rootVal = start; rootVal <= end; rootVal++) {
                List<TreeNode> leftSubtrees = generateTrees(start, rootVal - 1);
                List<TreeNode> rightSubtrees = generateTrees(rootVal + 1, end);
                for (TreeNode leftSubtree : leftSubtrees) {
                    for (TreeNode rightSubtree : rightSubtrees) {
                        TreeNode root = new TreeNode(rootVal);
                        root.left = leftSubtree;
                        root.right = rightSubtree;
                        trees.add(root);
                    }
                }
            }
        }
        return trees;
    }
}