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
    public TreeNode balanceBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;
        List<TreeNode> inorderTraversal = inorderTraversal(root);
        return balanceBST(inorderTraversal);
    }

    public List<TreeNode> inorderTraversal(TreeNode root) {
        List<TreeNode> inorderTraversal = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode visitNode = stack.pop();
            inorderTraversal.add(visitNode);
            node = visitNode.right;
        }
        return inorderTraversal;
    }

    public TreeNode balanceBST(List<TreeNode> inorderTraversal) {
        int size = inorderTraversal.size();
        if (size == 1) {
            TreeNode root = new TreeNode(inorderTraversal.get(0).val);
            return root;
        } else if (size == 2) {
            TreeNode root = new TreeNode(inorderTraversal.get(1).val);
            TreeNode leftChild = new TreeNode(inorderTraversal.get(0).val);
            root.left = leftChild;
            return root;
        } else if (size == 3) {
            TreeNode root = new TreeNode(inorderTraversal.get(1).val);
            TreeNode leftChild = new TreeNode(inorderTraversal.get(0).val);
            TreeNode rightChild = new TreeNode(inorderTraversal.get(2).val);
            root.left = leftChild;
            root.right = rightChild;
            return root;
        } else {
            int rootIndex = (size - 1) / 2;
            TreeNode root = new TreeNode(inorderTraversal.get(rootIndex).val);
            List<TreeNode> leftInorderTraversal = new ArrayList<TreeNode>();
            List<TreeNode> rightInorderTraversal = new ArrayList<TreeNode>();
            for (int i = 0; i < rootIndex; i++)
                leftInorderTraversal.add(inorderTraversal.get(i));
            for (int i = rootIndex + 1; i < size; i++)
                rightInorderTraversal.add(inorderTraversal.get(i));
            root.left = balanceBST(leftInorderTraversal);
            root.right = balanceBST(rightInorderTraversal);
            return root;
        }
    }
}