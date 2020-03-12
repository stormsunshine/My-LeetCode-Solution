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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        Map<TreeNode, TreeNode> childParentMap = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
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
        boolean flag = true;
        while (flag) {
            flag = false;
            Set<TreeNode> keySet = childParentMap.keySet();
            Set<TreeNode> removeSet = new HashSet<TreeNode>();
            for (TreeNode node : keySet) {
                if (isLeaf(node) && node.val == target) {
                    TreeNode parent = childParentMap.get(node);
                    if (parent == null)
                        return null;
                    else {
                        if (node == parent.left)
                            parent.left = null;
                        else if (node == parent.right)
                            parent.right = null;
                        removeSet.add(node);
                        flag = true;
                    }
                }
            }
            for (TreeNode node : removeSet)
                childParentMap.remove(node);
        }
        if (isLeaf(root) && root.val == target)
            root = null;
        return root;
    }

    public boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}