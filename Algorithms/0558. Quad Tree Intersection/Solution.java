/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf)
            return quadTree1.val ? quadTree1 : quadTree2;
        else if (quadTree2.isLeaf)
            return quadTree2.val ? quadTree2 : quadTree1;
        else {
            Node root = new Node();
            Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val && topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
                root.val = topLeft.val;
                root.isLeaf = true;
            } else {
                root.topLeft = topLeft;
                root.topRight = topRight;
                root.bottomLeft = bottomLeft;
                root.bottomRight = bottomRight;
            }
            return root;
        }
    }
}