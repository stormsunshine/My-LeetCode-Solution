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
    public Node inorderSuccessor(Node x) {
        if (x.right != null) {
            Node successor = x.right;
            while (successor.left != null)
                successor = successor.left;
            return successor;
        } else {
            Node child = x;
            Node parent = x.parent;
            while (parent != null && child != parent.left) {
                child = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
}