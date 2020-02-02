/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> originalCopyMap = new HashMap<Node, Node>();
        Node newNode = new Node(node.val);
        originalCopyMap.put(node, newNode);
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            Node copyNode = originalCopyMap.get(curNode);
            List<Node> neighbors = curNode.neighbors;
            for (Node neighbor : neighbors) {
                if (originalCopyMap.containsKey(neighbor)) {
                    Node copyNeighbor = originalCopyMap.get(neighbor);
                    copyNode.neighbors.add(copyNeighbor);
                } else {
                    Node copyNeighbor = new Node(neighbor.val);
                    originalCopyMap.put(neighbor, copyNeighbor);
                    copyNode.neighbors.add(copyNeighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return newNode;
    }
}