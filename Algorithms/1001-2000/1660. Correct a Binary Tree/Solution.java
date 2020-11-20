/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode correctBinaryTree(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Set<TreeNode> set = new HashSet<TreeNode>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                set.add(node);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    parentMap.put(left, node);
                    queue.offer(left);
                }
                if (right != null) {
                    if (parentMap.containsKey(right)) {
                        TreeNode parent = parentMap.get(node);
                        if (node == parent.left)
                            parent.left = null;
                        else if (node == parent.right)
                            parent.right = null;
                        return root;
                    } else {
                        parentMap.put(right, node);
                        queue.offer(right);
                    }
                }
            }
        }
        return root;
    }
}