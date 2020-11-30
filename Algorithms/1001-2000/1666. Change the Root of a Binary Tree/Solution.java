/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node flipBinaryTree(Node root, Node leaf) {
        if (root == leaf)
            return root;
        Node node = leaf;
        leaf.left = leaf.parent;
        leaf.right = null;
        leaf.parent = null;
        while (node.left != root) {
            if (node.left.right == node)
                node.left.right = node.left.left;
            node.left.left = node.left.parent;
            node.left.parent = node;
            node = node.left;
        }
        if (node.left.left == node)
            node.left.left = null;
        else
            node.left.right = null;
        node.left.parent = node;
        return leaf;
    }
}