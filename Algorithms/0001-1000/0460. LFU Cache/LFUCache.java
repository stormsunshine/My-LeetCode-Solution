class LFUCache {
    Map<Integer, Node> cache;
    Map<Integer, DoublyLinkedList> frequencyMap;
    int size;
    int capacity;
    int minFrequency;

    public LFUCache(int capacity) {
        cache = new HashMap<Integer, Node>();
        frequencyMap = new HashMap<Integer, DoublyLinkedList>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        else {
            increaseFrequency(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if (capacity == 0)
            return;
        Node node = cache.get(key);
        if (node == null) {
            if (size == capacity) {
                DoublyLinkedList minList = frequencyMap.get(minFrequency);
                Node removeNode = minList.tail.prev;
                cache.remove(removeNode.key);
                minList.remove(removeNode);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            DoublyLinkedList list = frequencyMap.get(1);
            if (list == null) {
                list = new DoublyLinkedList();
                frequencyMap.put(1, list);
            }
            list.add(newNode);
            size++;
            minFrequency = 1;
        } else {
            node.value = value;
            increaseFrequency(node);
        }
    }

    private void increaseFrequency(Node node) {
        int frequency = node.frequency;
        DoublyLinkedList prevList = frequencyMap.get(frequency);
        prevList.remove(node);
        if (frequency == minFrequency && prevList.size == 0)
            minFrequency = frequency + 1;
        node.frequency++;
        DoublyLinkedList newList = frequencyMap.get(frequency + 1);
        if (newList == null) {
            newList = new DoublyLinkedList();
            frequencyMap.put(frequency + 1, newList);
        }
        newList.add(node);
    }
}

class Node {
    int key;
    int value;
    int frequency = 1;
    Node prev;
    Node next;

    public Node() {
        
    }
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {
    int size;
    Node head;
    Node tail;

    public DoublyLinkedList() {
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node) {
        size--;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void add(Node node) {
        size++;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */