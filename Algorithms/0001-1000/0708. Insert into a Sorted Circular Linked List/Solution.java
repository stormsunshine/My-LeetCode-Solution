/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }
        if (head.next == head) {
            insertNode.next = head;
            head.next = insertNode;
            return head;
        }
        if (head.val == insertVal) {
            insertNode.next = head.next;
            head.next = insertNode;
        } else if (head.val < insertVal) {
            Node temp = head;
            while (temp.next != head && temp.next.val >= head.val && temp.next.val < insertVal)
                temp = temp.next;
            insertNode.next = temp.next;
            temp.next = insertNode;
        } else {
            Node temp = head;
            while (temp.next != head && temp.val <= temp.next.val)
                temp = temp.next;
            while (temp.next != head && temp.next.val < insertVal)
                temp = temp.next;
            insertNode.next = temp.next;
            temp.next = insertNode;
        }
        return head;
    }
}