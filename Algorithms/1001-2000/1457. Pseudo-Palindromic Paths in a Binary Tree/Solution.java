/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int count = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<String> pathQueue = new LinkedList<String>();
        nodeQueue.offer(root);
        pathQueue.offer(String.valueOf(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                if (canFormPalindrome(path))
                    count++;
            } else {
                if (left != null) {
                    StringBuffer sb = new StringBuffer(path);
                    sb.append(left.val);
                    nodeQueue.offer(left);
                    pathQueue.offer(sb.toString());
                }
                if (right != null) {
                    StringBuffer sb = new StringBuffer(path);
                    sb.append(right.val);
                    nodeQueue.offer(right);
                    pathQueue.offer(sb.toString());
                }
            }
        }
        return count;
    }

    public boolean canFormPalindrome(String path) {
        Set<Character> set = new HashSet<Character>();
        int length = path.length();
        for (int i = 0; i < length; i++) {
            char c = path.charAt(i);
            if (!set.add(c))
                set.remove(c);
        }
        return set.size() <= 1;
    }
}