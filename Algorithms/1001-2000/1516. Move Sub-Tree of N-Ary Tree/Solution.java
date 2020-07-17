/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node moveSubTree(Node root, Node p, Node q) {
        Map<Node, Node> parentMap = new HashMap<Node, Node>();
        Deque<Node> stack = new LinkedList<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                Node child = children.get(i);
                parentMap.put(child, node);
                stack.push(child);
            }
        }
        if (parentMap.get(p) == q)
            return root;
        boolean flag = false;
        Node temp = q;
        while (temp != null) {
            Node parent = parentMap.get(temp);
            if (parent == p) {
                flag = true;
                break;
            } else
                temp = parent;
        }
        if (parentMap.containsKey(p)) {
            Node pParent = parentMap.get(p);
            if (flag) {
                Node qParent = parentMap.get(q);
                qParent.children.remove(q);
                int index = pParent.children.indexOf(p);
                pParent.children.set(index, q);
            } else
                pParent.children.remove(p);
            q.children.add(p);
            return root;
        } else {
            Node qParent = parentMap.get(q);
            qParent.children.remove(q);
            q.children.add(p);
            return q;
        }
    }
}