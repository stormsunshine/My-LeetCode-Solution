class LRUCache {
    int capacity;
	Map<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        else {
            remove(node);
            setHead(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        } else {
            Node node = new Node(key, value);
            setHead(node);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            map.put(key, node);
        }
    }

    public void remove(Node node) {
        Node prev = node.prev, next = node.next;
        if (prev != null)
            prev.next = next;
        else
            head = next;
        if (next != null)
            next.prev = prev;
        else
            tail = prev;
    }

    public void setHead(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null)
            head.prev = node;
        head = node;
        if (tail == null)
            tail = head;
    }
}

class Node {
	int key;
	int value;
	Node prev;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */