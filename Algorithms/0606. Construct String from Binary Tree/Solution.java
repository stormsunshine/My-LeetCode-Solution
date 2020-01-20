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
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        if (t.left == null && t.right == null)
            return String.valueOf(t.val);
        StringBuffer sb = new StringBuffer();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        stack.push(t);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (visited.contains(node)) {
                stack.pop();
                sb.append(")");
            } else {
                visited.add(node);
                sb.append("(");
                sb.append(node.val);
                TreeNode left = node.left, right = node.right;
                if (left == null && right != null)
                    sb.append("()");
                if (right != null)
                    stack.push(right);
                if (left != null)
                    stack.push(left);
            }
        }
        String treeStr = sb.toString().substring(1, sb.length() - 1);
        return treeStr;
    }
}