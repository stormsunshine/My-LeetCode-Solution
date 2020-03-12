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
    public TreeNode[] splitBST(TreeNode root, int V) {
        List<Integer> preorderTraversal = preorderTraversal(root);
        List<Integer> preorderTraversal0 = new ArrayList<Integer>();
        List<Integer> preorderTraversal1 = new ArrayList<Integer>();
        int size = preorderTraversal.size();
        for (int i = 0; i < size; i++) {
            int value = preorderTraversal.get(i);
            if (value <= V)
                preorderTraversal0.add(value);
            else
                preorderTraversal1.add(value);
        }
        int length0 = preorderTraversal0.size();
        int[] preorder0 = new int[length0];
        for (int i = 0; i < length0; i++)
            preorder0[i] = preorderTraversal0.get(i);
        int length1 = preorderTraversal1.size();
        int[] preorder1 = new int[length1];
        for (int i = 0; i < length1; i++)
            preorder1[i] = preorderTraversal1.get(i);
        int[] inorder0 = new int[length0];
        System.arraycopy(preorder0, 0, inorder0, 0, length0);
        Arrays.sort(inorder0);
        int[] inorder1 = new int[length1];
        System.arraycopy(preorder1, 0, inorder1, 0, length1);
        Arrays.sort(inorder1);
        TreeNode[] newBST = new TreeNode[2];
        newBST[0] = buildTree(preorder0, inorder0);
        newBST[1] = buildTree(preorder1, inorder1);
        return newBST;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderTraversal = new ArrayList<Integer>();
        if (root == null)
            return preorderTraversal;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preorderTraversal.add(node.val);
            TreeNode left = node.left, right = node.right;
            if (right != null)
                stack.push(right);
            if (left != null)
                stack.push(left);
        }
        return preorderTraversal;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}