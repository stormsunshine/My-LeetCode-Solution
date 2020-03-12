/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        ListNode temp1 = l1, temp2 = l2;
        while (temp1 != null) {
            stack1.push(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            stack2.push(temp2);
            temp2 = temp2.next;
        }
        Stack<ListNode> stackSum = new Stack<ListNode>();
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode node1 = stack1.pop(), node2 = stack2.pop();
            int curVal = carry + node1.val + node2.val;
            carry = curVal / 10;
            curVal %= 10;
            ListNode nodeSum = new ListNode(curVal);
            if (!stackSum.isEmpty())
                nodeSum.next = stackSum.peek();
            stackSum.push(nodeSum);
        }
        while (!stack1.isEmpty()) {
            ListNode node1 = stack1.pop();
            int curVal = carry + node1.val;
            carry = curVal / 10;
            curVal %= 10;
            ListNode nodeSum = new ListNode(curVal);
            if (!stackSum.isEmpty())
                nodeSum.next = stackSum.peek();
            stackSum.push(nodeSum);
        }
        while (!stack2.isEmpty()) {
            ListNode node2 = stack2.pop();
            int curVal = carry + node2.val;
            carry = curVal / 10;
            curVal %= 10;
            ListNode nodeSum = new ListNode(curVal);
            if (!stackSum.isEmpty())
                nodeSum.next = stackSum.peek();
            stackSum.push(nodeSum);
        }
        while (carry > 0) {
            int curVal = carry % 10;
            carry /= 10;
            ListNode curNode = new ListNode(curVal);
            if (!stackSum.isEmpty())
                curNode.next = stackSum.peek();
            stackSum.push(curNode);
        }
        return stackSum.peek();
    }
}