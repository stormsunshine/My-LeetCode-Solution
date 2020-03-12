/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        stack.push(head);
        while (lastSorted.next != null) {
        	while (lastSorted.next != null && lastSorted.next.val >= lastSorted.val) {
        		lastSorted = lastSorted.next;
        		stack.push(lastSorted);
        	}
            if (lastSorted.next == null)
                break;
        	ListNode nextNode = lastSorted.next;
            int nextVal = nextNode.val;
            while (!stack.isEmpty() && stack.peek().val > nextVal)
                stack.pop();
            lastSorted.next = nextNode.next;
            if (stack.isEmpty()) {
                nextNode.next = dummyHead.next;
                dummyHead.next = nextNode;
            } else {
                nextNode.next = stack.peek().next;
                stack.peek().next = nextNode;
            }
            ListNode temp = stack.isEmpty() ? dummyHead.next : stack.peek().next;
            while (temp != lastSorted.next) {
            	stack.push(temp);
            	temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}