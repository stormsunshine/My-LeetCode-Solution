/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode leftLast = dummyHead;
        while (leftLast.next != null && leftLast.next.val < x)
            leftLast = leftLast.next;
        ListNode rightFirst = leftLast.next;
        ListNode temp = rightFirst;
        while (temp != null) {
            ListNode next = temp.next;
            if (next == null)
                break;
            if (next.val < x) {
                temp.next = next.next;
                leftLast.next = next;
                leftLast = leftLast.next;
            } else
                temp = temp.next;
        }
        leftLast.next = rightFirst;
        return dummyHead.next;
    }
}