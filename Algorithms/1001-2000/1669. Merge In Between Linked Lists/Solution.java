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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start2 = list2, end2 = list2;
        while (end2.next != null)
            end2 = end2.next;
        ListNode insertStart = list1, insertEnd = list1;
        for (int i = 1; i < a; i++)
            insertStart = insertStart.next;
        for (int i = 0; i <= b; i++)
            insertEnd = insertEnd.next;
        insertStart.next = start2;
        end2.next = insertEnd;
        return list1;
    }
}