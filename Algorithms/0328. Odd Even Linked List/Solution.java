/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode oddTemp = oddHead, evenTemp = evenHead;
        while (oddTemp != null && evenTemp != null) {
            if (evenTemp.next == null) {
                oddTemp.next = evenHead;
                break;
            } else if (evenTemp.next.next == null) {
                oddTemp.next = oddTemp.next.next;
                evenTemp.next = null;
                oddTemp = oddTemp.next;
                oddTemp.next = evenHead;
                break;
            } else {
                oddTemp.next = oddTemp.next.next;
                evenTemp.next = evenTemp.next.next;
                oddTemp = oddTemp.next;
                evenTemp = evenTemp.next;
            }
        }
        return head;
    }
}