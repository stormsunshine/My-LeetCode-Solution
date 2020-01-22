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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 == null || root2 == null)
            return false;
        List<Integer> leafValueSequence1 = leafValueSequence(root1);
        List<Integer> leafValueSequence2 = leafValueSequence(root2);
        if (leafValueSequence1.size() != leafValueSequence2.size())
            return false;
        int size = leafValueSequence1.size();
        for (int i = 0; i < size; i++) {
            if (leafValueSequence1.get(i) != leafValueSequence2.get(i))
                return false;
        }
        return true;
    }

    public List<Integer> leafValueSequence(TreeNode root) {
        List<Integer> leafValueSequence = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (!flag) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    leafValueSequence.add(node.val);
                }
            } else {
                flag = false;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    TreeNode left = node.left, right = node.right;
                    if (left == null && right == null)
                        queue.offer(node);
                    else {
                        flag = true;
                        if (left != null)
                            queue.offer(left);
                        if (right != null)
                            queue.offer(right);
                    }
                }
            }
        }
        return leafValueSequence;
    }
}