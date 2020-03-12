/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp != null) {
            while (temp.next != null && temp.next.val == val)
                temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyHead.next;
    }
}