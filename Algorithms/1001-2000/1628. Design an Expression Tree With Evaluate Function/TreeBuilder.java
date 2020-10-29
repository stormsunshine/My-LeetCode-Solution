/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    protected String val;
    protected int evaluateNum;
    protected Node left, right;

    public Node(String val) {
        this(val, null, null);
    }

    public Node(String val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public abstract int evaluate();
    // define your fields here
}

class NumNode extends Node {
    public NumNode(String val) {
        super(val);
        evaluateNum = Integer.parseInt(val);
    }

    public int evaluate() {
        return evaluateNum;
    }
}

class OpNode extends Node {
    public OpNode(String val, Node left, Node right) {
        super(val, left, right);
        evaluateNum = calculate();
    }

    public int evaluate() {
        return evaluateNum;
    }

    private int calculate() {
        int leftEvaluate = left.evaluate(), rightEvaluate = right.evaluate();
        char op = val.charAt(0);
        switch (op) {
            case '+':
                return leftEvaluate + rightEvaluate;
            case '-':
                return leftEvaluate - rightEvaluate;
            case '*':
                return leftEvaluate * rightEvaluate;
            case '/':
                return leftEvaluate / rightEvaluate;
            default:
        }
        return 0;
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Deque<Node> stack = new LinkedList<Node>();
        int length = postfix.length;
        for (int i = 0; i < length; i++) {
            String val = postfix[i];
            if (Character.isDigit(val.charAt(0))) {
                Node node = new NumNode(val);
                stack.push(node);
            } else {
                Node node2 = stack.pop();
                Node node1 = stack.pop();
                Node node = new OpNode(val, node1, node2);
                stack.push(node);
            }
        }
        return stack.pop();
    }
}


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */