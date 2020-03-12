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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead, slow = dummyHead;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rootNode = slow.next;
        slow.next = null;
        ListNode rightHead = rootNode.next;
        TreeNode root = new TreeNode(rootNode.val);
        root.left = sortedListToBST(dummyHead.next);
        root.right = sortedListToBST(rightHead);
        return root;
    }
}