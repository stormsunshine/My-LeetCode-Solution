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
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        if (root.children == null || root.children.size() == 0)
            return 1;
        int maxDepth = 1;
        Queue<Node> queue = new LinkedList<Node>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        queue.offer(root);
        depthQueue.offer(1);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int depth = depthQueue.poll();
            maxDepth = Math.max(maxDepth, depth);
            List<Node> children = node.children;
            if (children != null && children.size() > 0) {
                int newDepth = depth + 1;
                for (Node child : children) {
                    queue.offer(child);
                    depthQueue.offer(newDepth);
                }
            }
        }
        return maxDepth;
    }
}