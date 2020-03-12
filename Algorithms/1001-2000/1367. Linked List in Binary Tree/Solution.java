/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        int headVal = head.val;
        Queue<TreeNode> listQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> searchQueue = new LinkedList<TreeNode>();
        searchQueue.offer(root);
        while (!searchQueue.isEmpty()) {
            TreeNode node = searchQueue.poll();
            if (node.val == headVal)
                listQueue.offer(node);
            TreeNode left = node.left, right = node.right;
            if (left != null)
                searchQueue.offer(left);
            if (right != null)
                searchQueue.offer(right);
        }
        ListNode temp = head.next;
        while (temp != null && !listQueue.isEmpty()) {
            int nextVal = temp.val;
            int size = listQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = listQueue.poll();
                TreeNode left = node.left, right = node.right;
                if (left != null && left.val == nextVal)
                    listQueue.offer(left);
                if (right != null && right.val == nextVal)
                    listQueue.offer(right);
            }
            temp = temp.next;
        }
        return !listQueue.isEmpty();
    }
}