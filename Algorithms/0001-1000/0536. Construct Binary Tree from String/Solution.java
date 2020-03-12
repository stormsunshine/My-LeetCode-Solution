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
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0)
            return null;
        if (s.indexOf("(") < 0) {
            int val = Integer.parseInt(s);
            return new TreeNode(val);
        }
        StringBuffer sb = new StringBuffer(s);
        int strLength = s.length();
        for (int i = strLength - 1; i > 0; i--) {
            char curC = sb.charAt(i), prevC = sb.charAt(i - 1);
            if (curC == '(' || curC == ')' || prevC == '(' || prevC == ')')
                sb.insert(i, ' ');
        }
        String[] array = sb.toString().split(" ");
        int rootVal = Integer.parseInt(array[0]);
        TreeNode root = new TreeNode(rootVal);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<String> strStack = new Stack<String>();
        stack.push(root);
        strStack.push(array[0]);
        int length = array.length;
        for (int i = 1; i < length; i++) {
            String element = array[i];
            if (element.equals("("))
                strStack.push(element);
            else if (element.equals(")")) {
                while (!strStack.peek().equals("(")) {
                    stack.pop();
                    strStack.pop();
                }
                strStack.pop();
            } else {
                TreeNode parent = stack.peek();
                int val = Integer.parseInt(element);
                TreeNode node = new TreeNode(val);
                if (parent.left == null)
                    parent.left = node;
                else
                    parent.right = node;
                stack.push(node);
                strStack.push(element);
            }
        }
        return root;
    }
}