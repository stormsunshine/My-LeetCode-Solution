/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp != null && temp.next != null) {
            int curVal = temp.next.val;
            if (temp.next.next == null || temp.next.next.val != curVal) {
                temp = temp.next;
                continue;
            }
            while (temp.next.next != null && temp.next.next.val == curVal)
                temp.next.next = temp.next.next.next;
            temp.next = temp.next.next;
        }
        return dummyHead.next;
    }
}