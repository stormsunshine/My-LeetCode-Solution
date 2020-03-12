/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;
        ListNode lastBeforeReverse = null, reverseStart = null, reverseEnd = null, firstAfterReverse = null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        for (int i = 1; i < m; i++)
            temp = temp.next;
        lastBeforeReverse = temp;
        reverseStart = lastBeforeReverse.next;
        ListNode prev = lastBeforeReverse;
        ListNode curr = reverseStart;
        for (int i = m; i <= n; i++) {
            ListNode nextTemp = curr.next;
            if (i == n) {
                reverseEnd = curr;
                firstAfterReverse = nextTemp;
            }
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        lastBeforeReverse.next = reverseEnd;
        reverseStart.next = firstAfterReverse;
        return dummyHead.next;
    }
}