/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> preorder = new ArrayList<Integer>();
        if (root == null)
            return preorder;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            preorder.add(node.val);
            List<Node> children = node.children;
            int numOfChildren = children.size();
            for (int i = numOfChildren - 1; i >= 0; i--)
                stack.push(children.get(i));
        }
        return preorder;
    }
}