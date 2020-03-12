/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        if (stack.isEmpty())
            return head;
        ListNode lastNode = stack.pop();
        int lastVal = lastNode.val + 1;
        int carry = lastVal / 10;
        lastNode.val = lastVal % 10;
        while (!stack.isEmpty() && carry > 0) {
            ListNode node = stack.pop();
            int newVal = node.val + carry;
            carry = newVal / 10;
            node.val = newVal % 10;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
        }
        return dummyHead.next;
    }
}