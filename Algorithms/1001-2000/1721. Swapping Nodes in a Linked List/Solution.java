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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node1 = head;
        for (int i = 1; i < k; i++)
            node1 = node1.next;
        ListNode node2 = head, temp = node1;
        while (temp.next != null) {
            node2 = node2.next;
            temp = temp.next;
        }
        int val1 = node1.val, val2 = node2.val;
        node1.val = val2;
        node2.val = val1;
        return head;
    }
}