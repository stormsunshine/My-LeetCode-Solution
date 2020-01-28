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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<List<Integer>>();
        if (root == null)
            return leaves;
        Map<TreeNode, TreeNode> childParentMap = new HashMap<TreeNode, TreeNode>();
        while (root != null) {
            boolean flag = root.left == null && root.right == null;
            List<Integer> curLeaves = preorderTraversal(root, childParentMap);
            leaves.add(curLeaves);
            if (flag)
                break;
        }
        return leaves;
    }

    public List<Integer> preorderTraversal(TreeNode root, Map<TreeNode, TreeNode> childParentMap) {
        List<Integer> preorderTraversal = new ArrayList<Integer>();
        if (root == null)
            return preorderTraversal;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                preorderTraversal.add(node.val);
                TreeNode parent = childParentMap.get(node);
                if (parent != null) {
                    if (node == parent.left)
                        parent.left = null;
                    else if (node == parent.right)
                        parent.right = null;
                    childParentMap.remove(node);
                } else
                    break;
            } else {
                if (right != null) {
                    stack.push(right);
                    childParentMap.put(right, node);
                }
                if (left != null) {
                    stack.push(left);
                    childParentMap.put(left, node);
                }
            }
        }
        return preorderTraversal;
    }
}