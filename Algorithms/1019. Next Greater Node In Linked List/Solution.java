/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> nodesStack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            nodesStack.push(temp);
            temp = temp.next;
        }
        int length = nodesStack.size();
        int[] nextLarger = new int[length];
        Stack<Integer> largestStack = new Stack<Integer>();
        for (int i = length - 1; i >= 0; i--) {
            ListNode node = nodesStack.pop();
            int value = node.val;
            while (!largestStack.isEmpty() && largestStack.peek() <= value)
                largestStack.pop();
            if (!largestStack.isEmpty())
                nextLarger[i] = largestStack.peek();
            largestStack.push(value);
        }
        return nextLarger;
    }
}