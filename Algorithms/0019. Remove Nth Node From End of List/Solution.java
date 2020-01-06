/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pointer1 = dummyHead;
        ListNode pointer2 = dummyHead;
        for (int i = 0; i < n; i++) {
            pointer2 = pointer2.next;
            if (pointer2 == null)
                return head;
        }
        while (pointer1.next != null && pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        pointer1.next = pointer1.next.next;
        return dummyHead.next;
    }
}