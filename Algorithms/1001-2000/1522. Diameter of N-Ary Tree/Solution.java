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
    int path;

    public int diameter(Node root) {
        path = 1;
        depthFirstSearch(root);
        return path - 1;
    }

    public int depthFirstSearch(Node node) {
        if (node == null)
            return 0;
        int maxDepth1 = 0, maxDepth2 = 0;
        List<Node> children = node.children;
        for (Node child : children) {
            int curDepth = depthFirstSearch(child);
            if (curDepth > maxDepth1) {
                maxDepth2 = maxDepth1;
                maxDepth1 = curDepth;
            } else if (curDepth > maxDepth2)
                maxDepth2 = curDepth;
            path = Math.max(path, maxDepth1 + maxDepth2 + 1);
        }
        return maxDepth1 + 1;
    }

    public int depthFirstSearch(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = depthFirstSearch(node.left);
        int rightDepth = depthFirstSearch(node.right);
        path = Math.max(path, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}