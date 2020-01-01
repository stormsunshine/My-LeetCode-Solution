/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        k %= length;
        if (k == 0)
            return head;
        ListNode pointer1 = head, pointer2 = head;
        for (int i = 0; i < k; i++)
            pointer2 = pointer2.next;
        while (pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        ListNode newHead = pointer1.next;
        pointer1.next = null;
        pointer2.next = head;
        return newHead;
    }
}