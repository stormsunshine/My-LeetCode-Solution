/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode end = dummyHead;
        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null)
                    break;
            }
            if (end == null)
                break;
            ListNode start = prev.next;
            ListNode next = end.next;
            prev.next = reverseGroup(start, k);
            start.next = next;
            prev = start;
            end = start;
        }
        return dummyHead.next;
    }

    public ListNode reverseGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}