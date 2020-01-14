/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while (curr != null) {
            if (fast == null) {
                if (curr.val != prev.val)
                    return false;
                curr = curr.next;
                prev = prev.next;
            } else {
                ListNode tempNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tempNode;
                if (fast.next != null) {
                    fast = fast.next.next;
                    if (fast == null)
                         curr = curr.next;
                } else
                    fast = fast.next;
            }
        }
        return true;
    }
}