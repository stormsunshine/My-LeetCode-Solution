/**
 * Definition for a binary tree node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */
class Solution {
    Map<Node, NodeCopy> map = new HashMap<Node, NodeCopy>();

    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null)
            return null;
        if (map.containsKey(root))
            return map.get(root);
        NodeCopy newRoot = new NodeCopy(root.val);
        map.put(root, newRoot);
        newRoot.left = copyRandomBinaryTree(root.left);
        newRoot.right = copyRandomBinaryTree(root.right);
        newRoot.random = copyRandomBinaryTree(root.random);
        return newRoot;
    }
}