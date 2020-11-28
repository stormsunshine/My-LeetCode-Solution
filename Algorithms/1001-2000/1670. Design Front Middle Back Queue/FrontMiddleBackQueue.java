class FrontMiddleBackQueue {
    int size;
    Node start;
    Node end;
    Node middle;

    public FrontMiddleBackQueue() {
        size = 0;
        start = null;
        end = null;
        middle = null;
    }
    
    public void pushFront(int val) {
        Node node = new Node(val);
        if (size == 0) {
            start = node;
            end = node;
            middle = node;
        } else {
            node.next = start;
            start.prev = node;
            start = node;
            if (size % 2 == 1)
                middle = middle.prev;
        }
        size++;
    }
    
    public void pushMiddle(int val) {
        Node node = new Node(val);
        if (size == 0) {
            start = node;
            end = node;
            middle = node;
            size++;
        } else if (size == 1)
            pushFront(val);
        else {
            if (size % 2 == 0) {
                Node next = middle.next;
                middle.next = node;
                node.prev = middle;
                next.prev = node;
                node.next = next;
            } else {
                Node prev = middle.prev;
                middle.prev = node;
                node.next = middle;
                prev.next = node;
                node.prev = prev;
            }
            middle = node;
            size++;
        }
    }
    
    public void pushBack(int val) {
        Node node = new Node(val);
        if (size == 0) {
            start = node;
            end = node;
            middle = node;
        } else {
            node.prev = end;
            end.next = node;
            end = node;
            if (size % 2 == 0)
                middle = middle.next;
        }
        size++;
    }
    
    public int popFront() {
        if (size == 0)
            return -1;
        int val = start.val;
        if (size == 1) {
            start = null;
            end = null;
            middle = null;
            size--;
            return val;
        } else {
            start.next.prev = null;
            start = start.next;
            if (size % 2 == 0)
                middle = middle.next;
            size--;
            return val;
        }
    }
    
    public int popMiddle() {
        if (size == 0)
            return -1;
        int val = middle.val;
        if (size == 1) {
            start = null;
            end = null;
            middle = null;
            size--;
            return val;
        } else if (size == 2)
            return popFront();
        else {
            Node prev = middle.prev, next = middle.next;
            prev.next = next;
            next.prev = prev;
            if (size % 2 == 1)
                middle = prev;
            else
                middle = next;
            size--;
            return val;
        }
    }
    
    public int popBack() {
        if (size == 0)
            return -1;
        int val = end.val;
        if (size == 1) {
            start = null;
            end = null;
            middle = null;
            size--;
            return val;
        } else {
            end.prev.next = null;
            end = end.prev;
            if (size % 2 == 1)
                middle = middle.prev;
            size--;
            return val;
        }
    }
}

class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */