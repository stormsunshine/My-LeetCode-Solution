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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null)
            return "";
        StringBuffer sb = new StringBuffer();
        Stack<Node> nodeStack = new Stack<Node>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);
        int prevDepth = 0;
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            int depth = depthStack.pop();
            for (int i = prevDepth; i < depth; i++)
                sb.append("( ");
            for (int i = prevDepth; i > depth; i--)
                sb.append(") ");
            sb.append(node.val + " ");
            List<Node> children = node.children;
            int size = children.size();
            for (int i = size - 1; i >= 0; i--) {
                nodeStack.push(children.get(i));
                depthStack.push(depth + 1);
            }
            prevDepth = depth;
        }
        for (int i = prevDepth; i > 0; i--)
            sb.append(") ");
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] array = data.split(" ");
        Node root = new Node(Integer.parseInt(array[0]), new ArrayList<Node>());
        Stack<Node> nodeStack = new Stack<Node>();
        Stack<String> strStack = new Stack<String>();
        nodeStack.push(root);
        strStack.push(array[0]);
        Node parent = null;
        Map<Node, Node> parentMap = new HashMap<Node, Node>();
        int length = array.length;
        for (int i = 1; i < length; i++) {
            String str = array[i];
            if (str.equals("(")) {
                parent = nodeStack.peek();
                strStack.push(str);
            } else if (str.equals(")")) {
                while (!strStack.peek().equals("(")) {
                    nodeStack.pop();
                    strStack.pop();
                }
                strStack.pop();
                parent = parentMap.get(nodeStack.peek());
            } else {
                int value = Integer.parseInt(str);
                Node node = new Node(value, new ArrayList<Node>());
                parent.children.add(node);
                parentMap.put(node, parent);
                nodeStack.push(node);
                strStack.push(str);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));