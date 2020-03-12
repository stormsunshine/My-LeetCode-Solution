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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return root;
        Map<TreeNode, TreeNode> childParentMap = new HashMap<TreeNode, TreeNode>();
        List<TreeNode> nodesList = new ArrayList<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodesList.add(node);
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                childParentMap.put(left, node);
                queue.offer(left);
            }
            if (right != null) {
                childParentMap.put(right, node);
                queue.offer(right);
            }
        }
        for (int i = nodesList.size() - 1; i >= 0; i--) {
            TreeNode node = nodesList.get(i);
            if (node.val == 0) {
                if (node.left == null && node.right == null) {
                    TreeNode parent = childParentMap.get(node);
                    if (parent != null) {
                        if (node == parent.left)
                            parent.left = null;
                        else
                            parent.right = null;
                    } else {
                        root = null;
                        break;
                    }
                }
            }
        }
        return root;
    }
}