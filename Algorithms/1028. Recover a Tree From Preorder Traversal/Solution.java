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
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0)
            return null;
        StringBuffer sb = new StringBuffer(S);
        for (int i = S.length() - 1; i > 0; i--) {
            if (S.charAt(i) == '-' && S.charAt(i - 1) != '-')
                sb.insert(i, ',');
        }
        String[] array = sb.toString().split(",");
        int nodesCount = array.length;
        int rootVal = Integer.parseInt(array[0]);
        TreeNode root = new TreeNode(rootVal);
        if (nodesCount == 1)
            return root;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> levelStack = new Stack<Integer>();
        nodeStack.push(root);
        levelStack.push(0);
        for (int i = 1; i < nodesCount; i++) {
            String str = array[i];
            int level = str.lastIndexOf('-') + 1;
            int value = Integer.parseInt(str.substring(level));
            TreeNode node = new TreeNode(value);
            while (!levelStack.isEmpty() && levelStack.peek() >= level) {
                nodeStack.pop();
                levelStack.pop();
            }
            if (nodeStack.isEmpty())
                return null;
            TreeNode parent = nodeStack.peek();
            if (parent.left == null)
                parent.left = node;
            else if (parent.right == null)
                parent.right = node;
            else
                return null;
            nodeStack.push(node);
            levelStack.push(level);
        }
        return root;
    }
}