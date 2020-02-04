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
    public int maxProduct(TreeNode root) {
        final int MODULO = 1000000007;
        List<TreeNode> nodesList = new ArrayList<TreeNode>();
        Map<TreeNode, TreeNode> childParentMap = new HashMap<TreeNode, TreeNode>();
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
        for (int i = nodesList.size() - 1; i > 0; i--) {
            TreeNode node = nodesList.get(i);
            TreeNode parent = childParentMap.get(node);
            if (parent != null)
                parent.val += node.val;
        }
        long maxProduct = 0;
        for (int i = nodesList.size() - 1; i > 0; i--) {
            TreeNode node = nodesList.get(i);
            int value1 = node.val, value2 = root.val - node.val;
            long product = (long) value1 * (long) value2;
            maxProduct = Math.max(maxProduct, product);
        }
        int maxProductModulo = (int) (maxProduct % MODULO);
        return maxProductModulo;
    }
}