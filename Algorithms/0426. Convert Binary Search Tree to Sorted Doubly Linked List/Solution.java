/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        Node head = root, tail = root;
        while (head.left != null)
            head = head.left;
        while (tail.right != null)
            tail = tail.right;
        inorderTraversal(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void inorderTraversal(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        Node prevNode = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            Node visitNode = stack.pop();
            visitNode.left = prevNode;
            if (prevNode != null)
                prevNode.right = visitNode;
            node = visitNode.right;
            prevNode = visitNode;
        }
    }
}