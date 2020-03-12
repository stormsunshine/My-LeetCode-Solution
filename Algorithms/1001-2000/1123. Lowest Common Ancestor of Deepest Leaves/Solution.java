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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        List<TreeNode> deepestLeaves = new ArrayList<TreeNode>();
        Map<TreeNode, TreeNode> childParentMap = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            deepestLeaves.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left, right = node.right;
                if (left == null && right == null)
                    deepestLeaves.add(node);
                if (left != null) {
                    childParentMap.put(left, node);
                    queue.offer(left);
                }
                if (right != null) {
                    childParentMap.put(right, node);
                    queue.offer(right);
                }
            }
        }
        if (deepestLeaves.size() == 1)
            return deepestLeaves.get(0);
        Set<TreeNode> set = new HashSet<TreeNode>();
        for (TreeNode node : deepestLeaves) {
            TreeNode parent = childParentMap.get(node);
            set.add(parent);
        }
        while (set.size() > 1) {
            List<TreeNode> list = new ArrayList<TreeNode>(set);
            set.clear();
            for (TreeNode node : list) {
                TreeNode parent = childParentMap.get(node);
                set.add(parent);
            }
        }
        List<TreeNode> resultList = new ArrayList<TreeNode>(set);
        return resultList.get(0);
    }
}