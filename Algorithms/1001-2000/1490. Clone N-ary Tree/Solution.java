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
    public Node cloneTree(Node root) {
        if (root == null)
            return root;
        Node newRoot = new Node(root.val);
        List<Node> children = root.children;
        for (Node child : children) {
            Node newChild = cloneTree(child);
            newRoot.children.add(newChild);
        }
        return newRoot;
    }
}