class AllOne {
    Map<String, Integer> keyValueMap;
    Map<Integer, DoublyLinkedNode> valueNodeMap;
    DoublyLinkedNode head;
    DoublyLinkedNode tail;

    /** Initialize your data structure here. */
    public AllOne() {
        keyValueMap = new HashMap<String, Integer>();
        valueNodeMap = new HashMap<Integer, DoublyLinkedNode>();
        head = new DoublyLinkedNode();
        tail = new DoublyLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyValueMap.containsKey(key)) {
            int value = keyValueMap.get(key);
            int newValue = value + 1;
            keyValueMap.put(key, newValue);
            DoublyLinkedNode node = valueNodeMap.get(value);
            DoublyLinkedNode prev = node.prev, next = node.next;
            node.keySet.remove(key);
            if (node.keySet.isEmpty()) {
                prev.next = next;
                next.prev = prev;
                valueNodeMap.remove(value);
            }
            if (next.value == node.value + 1)
                next.keySet.add(key);
            else {
                DoublyLinkedNode newNode = new DoublyLinkedNode(newValue, key);
                valueNodeMap.put(newValue, newNode);
                prev = next.prev;
                prev.next = newNode;
                next.prev = newNode;
                newNode.prev = prev;
                newNode.next = next;
            }
        } else {
            keyValueMap.put(key, 1);
            DoublyLinkedNode node = valueNodeMap.get(1);
            if (node == null) {
                node = new DoublyLinkedNode(1, key);
                valueNodeMap.put(1, node);
                DoublyLinkedNode prevNext = head.next;
                head.next = node;
                prevNext.prev = node;
                node.prev = head;
                node.next = prevNext;
            } else
                node.keySet.add(key);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyValueMap.containsKey(key)) {
            int value = keyValueMap.get(key);
            int newValue = value - 1;
            if (newValue > 0)
                keyValueMap.put(key, newValue);
            else
                keyValueMap.remove(key);
            DoublyLinkedNode node = valueNodeMap.get(value);
            DoublyLinkedNode prev = node.prev, next = node.next;
            node.keySet.remove(key);
            if (node.keySet.isEmpty()) {
                prev.next = next;
                next.prev = prev;
                valueNodeMap.remove(value);
            }
            if (prev.value == node.value - 1)
                prev.keySet.add(key);
            else if (newValue > 0) {
                DoublyLinkedNode newNode = new DoublyLinkedNode(newValue, key);
                valueNodeMap.put(newValue, newNode);
                next = prev.next;
                prev.next = newNode;
                next.prev = newNode;
                newNode.prev = prev;
                newNode.next = next;
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.prev == head)
            return "";
        else
            return tail.prev.keySet.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail)
            return "";
        else
            return head.next.keySet.iterator().next();
    }
}

class DoublyLinkedNode {
    int value;
    Set<String> keySet;
    DoublyLinkedNode prev;
    DoublyLinkedNode next;

    public DoublyLinkedNode() {
        this(0);
    }

    public DoublyLinkedNode(int value) {
        this.value = value;
        this.keySet = new HashSet<String>();
    }

    public DoublyLinkedNode(int value, String key) {
        this.value = value;
        this.keySet = new HashSet<String>();
        keySet.add(key);
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */