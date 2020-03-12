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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<Integer, List<TreeNode>> depthNodesMap = new HashMap<Integer, List<TreeNode>>();
        Map<TreeNode, TreeNode> childParentMap = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            List<TreeNode> list = new ArrayList<TreeNode>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node);
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
            depthNodesMap.put(depth, list);
        }
        List<TreeNode> nodesList = depthNodesMap.get(depth);
        if (nodesList == null)
            return null;
        while (nodesList.size() > 1) {
            Set<TreeNode> set = new HashSet<TreeNode>();
            int size = nodesList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodesList.remove(0);
                TreeNode parent = childParentMap.get(node);
                if (parent != null)
                    set.add(parent);
            }
            for (TreeNode node : set)
                nodesList.add(node);
        }
        return nodesList.get(0);
    }
}