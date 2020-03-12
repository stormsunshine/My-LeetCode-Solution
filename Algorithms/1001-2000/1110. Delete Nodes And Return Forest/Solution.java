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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null)
            return new ArrayList<TreeNode>();
        Set<Integer> deleteSet = new HashSet<Integer>();
        for (int value : to_delete)
            deleteSet.add(value);
        List<TreeNode> nodesList = new ArrayList<TreeNode>();
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodesList.add(node);
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                map.put(left, node);
                queue.offer(left);
            }
            if (right != null) {
                map.put(right, node);
                queue.offer(right);
            }
        }
        List<TreeNode> forest = new ArrayList<TreeNode>();
        if (!deleteSet.contains(root.val))
            forest.add(root);
        for (int i = nodesList.size() - 1; i >= 0 && !deleteSet.isEmpty(); i--) {
            TreeNode node = nodesList.get(i);
            if (deleteSet.contains(node.val)) {
                TreeNode parent = map.get(node);
                if (parent != null) {
                    if (node == parent.left)
                        parent.left = null;
                    else if (node == parent.right)
                        parent.right = null;
                }
                TreeNode left = node.left, right = node.right;
                if (left != null)
                    forest.add(left);
                if (right != null)
                    forest.add(right);
                deleteSet.remove(node.val);
            }
        }
        return forest;
    }
}