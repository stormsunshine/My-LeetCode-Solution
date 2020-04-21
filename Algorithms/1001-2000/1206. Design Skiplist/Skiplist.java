class Skiplist {
    List<Node> heads;

    public Skiplist() {
        heads = new ArrayList<Node>();
        heads.add(new Node(-1));
    }
    
    public boolean search(int target) {
        int level = heads.size() - 1;
        Node searchNode = heads.get(level);
        while (level >= 0) {
            while (searchNode.next != null) {
                Node nextNode = searchNode.next;
                if (nextNode.val == target)
                    return true;
                else if (nextNode.val < target)
                    searchNode = nextNode;
                else
                    break;
            }
            level--;
            searchNode = searchNode.down;
        }
        return false;
    }
    
    public void add(int num) {
        Node node = new Node(num);
        Node[] nodes = searchNodes(num);
        int levels = nodes.length;
        Node prev = nodes[0];
        Node next = prev.next;
        node.prev = prev;
        node.next = next;
        if (prev != null)
            prev.next = node;
        if (next != null)
            next.prev = node;
        int level = 1;
        while (coinFlip()) {
            Node levelHead;
            if (level < levels)
                levelHead = nodes[level];
            else {
                levelHead = new Node(-level - 1);
                heads.add(levelHead);
                levelHead.down = heads.get(level - 1);
            }
            Node levelNode = new Node(num);
            levelNode.down = node;
            Node levelNext = levelHead.next;
            levelNode.prev = levelHead;
            levelNode.next = levelNext;
            if (levelHead != null)
                levelHead.next = levelNode;
            if (levelNext != null)
                levelNext.prev = levelNode;
            node = levelNode;
            level++;
        }
    }
    
    public boolean erase(int num) {
        Node[] nodes = searchNodes(num);
        int levels = nodes.length;
        boolean flag = false;
        for (int i = 0; i < levels; i++) {
            Node node = nodes[i];
            if (node.val == num) {
                flag = true;
                delete(node);
            }
        }
        return flag;
    }

    private Node[] searchNodes(int target) {
        Node[] nodes = new Node[heads.size()];
        int level = heads.size() - 1;
        Node searchNode = heads.get(level);
        while (level >= 0) {
            while (searchNode.next != null) {
                Node nextNode = searchNode.next;
                if (nextNode.val == target) {
                    searchNode = nextNode;
                    while (level >= 0) {
                        nodes[level] = searchNode;
                        searchNode = searchNode.down;
                        level--;
                    }
                    return nodes;
                } else if (nextNode.val < target)
                    searchNode = nextNode;
                else
                    break;
            }
            nodes[level] = searchNode;
            level--;
            searchNode = searchNode.down;
        }
        return nodes;
    }

    private boolean coinFlip() {
        int coinFlip = (int) (Math.random() * 2);
        return coinFlip == 1;
    }

    private void delete(Node node) {
        Node prev = node.prev, next = node.next;
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
    }
}

class Node {
    int val;
    Node prev;
    Node next;
    Node down;

    public Node(int val) {
        this.val = val;
        prev = null;
        next = null;
        down = null;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */