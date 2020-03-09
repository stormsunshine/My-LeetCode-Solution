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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null)
            return null;
        Map<Node, TreeNode> map = new HashMap<Node, TreeNode>();
        TreeNode binaryTreeRoot = new TreeNode(root.val);
        map.put(root, binaryTreeRoot);
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            TreeNode binaryTreeNode = map.get(node);
            List<Node> children = node.children;
            if (children != null) {
                int size = children.size();
                for (int i = 0; i < size; i++) {
                    Node child = children.get(i);
                    TreeNode binaryTreeChild = new TreeNode(child.val);
                    map.put(child, binaryTreeChild);
                    if (i == 0)
                        binaryTreeNode.left = binaryTreeChild;
                    else {
                        Node prevChild = children.get(i - 1);
                        TreeNode prevBinaryTreeChild = map.get(prevChild);
                        prevBinaryTreeChild.right = binaryTreeChild;
                    }
                    queue.offer(child);
                }
            }
        }
        return binaryTreeRoot;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null)
            return null;
        Map<TreeNode, Node> nodesMap = new HashMap<TreeNode, Node>();
        Node naryTreeRoot = new Node(root.val, new ArrayList<Node>());
        nodesMap.put(root, naryTreeRoot);
        Map<Node, Node> childParentMap = new HashMap<Node, Node>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Node naryTreeNode = nodesMap.get(node);
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                Node firstChild = new Node(left.val, new ArrayList<Node>());
                nodesMap.put(left, firstChild);
                naryTreeNode.children.add(firstChild);
                childParentMap.put(firstChild, naryTreeNode);
                queue.offer(left);
            }
            if (right != null) {
                Node nextChild = new Node(right.val, new ArrayList<Node>());
                nodesMap.put(right, nextChild);
                Node parent = childParentMap.get(naryTreeNode);
                parent.children.add(nextChild);
                childParentMap.put(nextChild, parent);
                queue.offer(right);
            }
        }
        return naryTreeRoot;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));