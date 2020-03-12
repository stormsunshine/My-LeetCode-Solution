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
    public List<Integer> postorder(Node root) {
        List<Integer> postorder = new ArrayList<Integer>();
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        if (root != null)
            stack1.push(root);
        while (!stack1.isEmpty()) {
            Node temp = stack1.pop();
            stack2.push(temp);
            List<Node> children = temp.children;
            int size = children.size();
            for (int i = 0; i < size; i++)
                stack1.add(children.get(i));
        }
        while (!stack2.isEmpty())
            postorder.add(stack2.pop().val);
        return postorder;
    }
}