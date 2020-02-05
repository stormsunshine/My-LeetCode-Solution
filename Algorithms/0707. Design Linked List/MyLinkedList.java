class MyLinkedList {
    Node head;
    Node tail;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size)
            return -1;
        else {
            Node node = head;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node.val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node addNode = new Node(val);
        if (size == 0) {
            head = addNode;
            tail = addNode;
        } else {
            addNode.next = head;
            head.prev = addNode;
            head = addNode;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node addNode = new Node(val);
        if (size == 0) {
            head = addNode;
            tail = addNode;
        } else {
            addNode.prev = tail;
            tail.next = addNode;
            tail = addNode;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0)
            addAtHead(val);
        else if (index == size)
            addAtTail(val);
        else if (index < size) {
            Node addNode = new Node(val);
            Node node = head;
            for (int i = 0; i < index; i++)
                node = node.next;
            Node prev = node.prev;
            addNode.prev = prev;
            addNode.next = node;
            prev.next = addNode;
            node.prev = addNode;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            if (head != null)
                head.prev = null;
            size--;
        } else if (index == size - 1) {
            tail = tail.prev;
            if (tail != null)
                tail.next = null;
            size--;
        } else if (index < size) {
            Node node = head;
            for (int i = 0; i < index; i++)
                node = node.next;
            Node prev = node.prev;
            prev.next = node.next;
            node.next.prev = prev;
            size--;
        }
    }
}

class Node {
    int val;
    Node prev;
    Node next;

    public Node() {
        
    }

    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */