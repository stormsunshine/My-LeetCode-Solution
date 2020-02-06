/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> preorderTraversal = preorderTraversal(root);
        String serialization = preorderTraversal.toString().replaceAll(" ", "");
        return serialization;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (data.length() == 0)
            return null;
        String[] strArray = data.split(",");
        int length = strArray.length;
        int[] preorder = new int[length];
        for (int i = 0; i < length; i++)
            preorder[i] = Integer.parseInt(strArray[i]);
        int[] inorder = new int[length];
        System.arraycopy(preorder, 0, inorder, 0, length);
        Arrays.sort(inorder);
        TreeNode root = buildTree(preorder, inorder);
        return root;
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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));