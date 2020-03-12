/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp != null) {
            ListNode zeroLast = removeZero(temp.next);
            if (zeroLast == null)
                temp = temp.next;
            else
                temp.next = zeroLast.next;
        }
        return dummyHead.next;
    }

    public ListNode removeZero(ListNode node) {
        ListNode temp = node;
        int sum = 0;
        while (temp != null) {
            sum += temp.val;
            if (sum == 0)
                return temp;
            else
                temp = temp.next;
        }
        return null;
    }
}