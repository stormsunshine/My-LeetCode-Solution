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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if (root == null)
            return paths;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<String> pathQueue = new LinkedList<String>();
        nodeQueue.offer(root);
        pathQueue.offer(String.valueOf(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null)
                paths.add(path);
            else {
                if (left != null) {
                    nodeQueue.offer(left);
                    String leftPath = path + "->" + left.val;
                    pathQueue.offer(leftPath);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    String rightPath = path + "->" + right.val;
                    pathQueue.offer(rightPath);
                }
            }
        }
        return paths;
    }
}