class BrowserHistory {
    Node head;
    Node tail;
    Node curr;
    int size;
    int index;

    public BrowserHistory(String homepage) {
        head = new Node("");
        tail = new Node("");
        Node home = new Node(homepage);
        head.next = home;
        home.prev = head;
        home.next = tail;
        tail.prev = home;
        curr = home;
        size = 1;
        index = 1;
    }
    
    public void visit(String url) {
        while (size > index) {
            curr.next = curr.next.next;
            size--;
        }
        Node node = new Node(url);
        curr.next = node;
        node.prev = curr;
        node.next = tail;
        tail.prev = node;
        curr = node;
        size++;
        index++;
    }
    
    public String back(int steps) {
        steps = Math.min(steps, index - 1);
        for (int i = 1; i <= steps; i++) {
            curr = curr.prev;
            index--;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        steps = Math.min(steps, size - index);
        for (int i = 1; i <= steps; i++) {
            curr = curr.next;
            index++;
        }
        return curr.url;
    }
}

class Node {
    String url;
    Node prev;
    Node next;

    public Node(String url) {
        this.url = url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */