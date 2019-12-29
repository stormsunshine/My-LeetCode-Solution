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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> elements1 = inorderTraversal(root1);
        List<Integer> elements2 = inorderTraversal(root2);
        List<Integer> allElements = new ArrayList<Integer>();
        int size1 = elements1.size(), size2 = elements2.size();
        int index1 = 0, index2 = 0;
        while (index1 < size1 && index2 < size2) {
            int element1 = elements1.get(index1), element2 = elements2.get(index2);
            if (element1 <= element2) {
                allElements.add(element1);
                index1++;
            } else {
                allElements.add(element2);
                index2++;
            }
        }
        while (index1 < size1) {
            int element1 = elements1.get(index1);
            allElements.add(element1);
            index1++;
        }
        while (index2 < size2) {
            int element2 = elements2.get(index2);
            allElements.add(element2);
            index2++;
        }
        return allElements;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderTraversal = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode visitNode = stack.pop();
            inorderTraversal.add(visitNode.val);
            node = visitNode.right;
        }
        return inorderTraversal;
    }
}