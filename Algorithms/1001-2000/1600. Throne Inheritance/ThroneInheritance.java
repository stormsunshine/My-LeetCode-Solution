class ThroneInheritance {
    Map<String, Node> nodeMap;
    Map<Node, Node> parentMap;
    Node root;

    public ThroneInheritance(String kingName) {
        nodeMap = new HashMap<String, Node>();
        parentMap = new HashMap<Node, Node>();
        root = new Node(kingName);
        nodeMap.put(kingName, root);
    }
    
    public void birth(String parentName, String childName) {
        Node parent = nodeMap.get(parentName);
        Node child = new Node(childName);
        nodeMap.put(childName, child);
        parentMap.put(child, parent);
        parent.addChild(child);
    }
    
    public void death(String name) {
        Node deadNode = nodeMap.get(name);
        deadNode.alive = false;
    }
    
    public List<String> getInheritanceOrder() {
        List<String> inheritanceOrder = new ArrayList<String>();
        preorder(inheritanceOrder, root);
        return inheritanceOrder;
    }

    private void preorder(List<String> inheritanceOrder, Node node) {
        if (node.alive)
            inheritanceOrder.add(node.name);
        List<Node> children = node.children;
        int size = children.size();
        for (int i = 0; i < size; i++)
            preorder(inheritanceOrder, children.get(i));
    }
}

class Node {
    String name;
    boolean alive;
    List<Node> children;

    public Node(String name) {
        this.name = name;
        this.alive = true;
        this.children = new ArrayList<Node>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */