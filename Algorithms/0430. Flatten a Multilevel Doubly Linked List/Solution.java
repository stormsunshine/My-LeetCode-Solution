/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null)
            return head;
        Stack<Node> stack = new Stack<Node>();
        Node temp = head;
        while (!stack.isEmpty() || temp.next != null || temp.child != null) {
            if (temp.next != null) {
                if (temp.child != null) {
                    stack.push(temp);
                    temp = temp.child;
                } else
                    temp = temp.next;
            } else if (temp.child != null) {
                Node nextNode = temp.child;
                temp.next = nextNode;
                nextNode.prev = temp;
                temp.child = null;
            } else {
                Node prevNode = stack.pop();
                Node prevNext = prevNode.next;
                Node prevChild = prevNode.child;
                prevNode.next = prevChild;
                prevChild.prev = prevNode;
                prevNode.child = null;
                temp.next = prevNext;
                if (prevNext != null)
                    prevNext.prev = temp;
            }
        }
        return head;
    }

}