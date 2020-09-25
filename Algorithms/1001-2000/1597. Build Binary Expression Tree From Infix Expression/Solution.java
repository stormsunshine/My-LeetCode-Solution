/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Node expTree(String s) {
        if (s == null || s.length() == 0)
            return null;
        Deque<Character> opStack = new LinkedList<Character>();
        Deque<Node> nodeStack = new LinkedList<Node>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                Node node = new Node(c);
                nodeStack.push(node);
            } else {
                if (c == '(')
                    opStack.push(c);
                else if (c == ')') {
                    while (!opStack.isEmpty() && opStack.peek() != '(')
                        createNode(nodeStack, opStack.pop());
                    if (!opStack.isEmpty() && opStack.peek() == '(')
                        opStack.pop();
                } else {
                    if (opStack.isEmpty() || opStack.peek() == '(')
                        opStack.push(c);
                    else {
                        int precedence = getPrecedence(c);
                        while (!opStack.isEmpty() && getPrecedence(opStack.peek()) >= precedence)
                            createNode(nodeStack, opStack.pop());
                        opStack.push(c);
                    }
                }
            }
        }
        while (!opStack.isEmpty())
            createNode(nodeStack, opStack.pop());
        return nodeStack.pop();
    }

    public void createNode(Deque<Node> nodeStack, char op) {
        Node right = nodeStack.pop();
        Node left = nodeStack.pop();
        Node node = new Node(op, left, right);
        nodeStack.push(node);
    }

    public int getPrecedence(char op) {
        if (op == '*' || op == '/')
            return 2;
        else if (op == '+' || op == '-')
            return 1;
        else
            return 0;
    }
}