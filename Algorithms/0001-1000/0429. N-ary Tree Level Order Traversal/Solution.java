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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
        if (root == null)
            return levelOrder;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                curLevel.add(node.val);
                List<Node> children = node.children;
                if (children != null && children.size() > 0) {
                    int childrenCount = children.size();
                    for (int j = 0; j < childrenCount; j++)
                        queue.offer(children.get(j));
                }
            }
            levelOrder.add(curLevel);
        }
        return levelOrder;
    }
}