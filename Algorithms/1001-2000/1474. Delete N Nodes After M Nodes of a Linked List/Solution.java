/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp != null && temp.next != null) {
            for (int i = 1; i <= m && temp != null && temp.next != null; i++)
                temp = temp.next;
            for (int i = 1; i <= n && temp != null && temp.next != null; i++)
                temp.next = temp.next.next;
        }
        return dummyHead.next;
    }
}