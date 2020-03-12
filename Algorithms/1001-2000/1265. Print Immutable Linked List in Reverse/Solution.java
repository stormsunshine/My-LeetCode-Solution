/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<ImmutableListNode>();
        ImmutableListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.getNext();
        }
        while (!stack.isEmpty()) {
            ImmutableListNode node = stack.pop();
            node.printValue();
        }
    }
}