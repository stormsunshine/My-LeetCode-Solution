/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next == null ? fast.next : fast.next.next;
            slow = slow.next;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = slow;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (temp != slow && !stack.isEmpty()) {
            ListNode prevNext = temp.next;
            ListNode newNext = stack.pop();
            temp.next = newNext;
            if (prevNext != newNext)
                newNext.next = prevNext;
            else
                newNext.next = null;
            temp = prevNext;
            if (stack.isEmpty())
                temp.next = null;
        }
    }
}