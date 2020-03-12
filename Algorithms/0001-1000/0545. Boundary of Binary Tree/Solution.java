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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundaryList = new ArrayList<Integer>();
        if (root == null)
            return boundaryList;
        if (!isLeaf(root))
            boundaryList.add(root.val);
        TreeNode node = root.left;
        while (node != null) {
            if (!isLeaf(node))
                boundaryList.add(node.val);
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
        addLeafNodes(boundaryList, root);
        Stack<Integer> stack = new Stack<Integer>();
        node = root.right;
        while (node != null) {
            if (!isLeaf(node))
                stack.push(node.val);
            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }
        while (!stack.isEmpty())
            boundaryList.add(stack.pop());
        return boundaryList;
    }

    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    public void addLeafNodes(List<Integer> boundaryList, TreeNode root) {
        if (isLeaf(root))
            boundaryList.add(root.val);
        else {
            if (root.left != null)
                addLeafNodes(boundaryList, root.left);
            if (root.right != null)
                addLeafNodes(boundaryList, root.right);
        }
    }
}