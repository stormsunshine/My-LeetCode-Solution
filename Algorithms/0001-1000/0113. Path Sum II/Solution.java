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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        if (root == null)
            return paths;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> path = new ArrayList<Integer>();
                path.add(root.val);
                paths.add(path);
            }
            return paths;
        }
        int remain = sum - root.val;
        List<List<Integer>> leftPaths = pathSum(root.left, remain);
        List<List<Integer>> rightPaths = pathSum(root.right, remain);
        for (List<Integer> path : leftPaths) {
            path.add(0, root.val);
            paths.add(path);
        }
        for (List<Integer> path : rightPaths) {
            path.add(0, root.val);
            paths.add(path);
        }
        return paths;
    }
}