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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicateList = new ArrayList<TreeNode>();
        if (root == null)
            return duplicateList;
        Set<String> visitedSet = new HashSet<String>();
        Set<String> duplicateSet = new HashSet<String>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String str = treeToString(node);
            if (!visitedSet.add(str) && duplicateSet.add(str))
                duplicateList.add(node);
            TreeNode left = node.left, right = node.right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        return duplicateList;
    }

    public String treeToString(TreeNode root) {
        List<String> list = new ArrayList<String>();
        list.add(String.valueOf(root.val));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                list.add(String.valueOf(left.val));
                queue.offer(left);
            } else
                list.add("null");
            if (right != null) {
                list.add(String.valueOf(right.val));
                queue.offer(right);
            } else
                list.add("null");
        }
        return list.toString();
    }
}