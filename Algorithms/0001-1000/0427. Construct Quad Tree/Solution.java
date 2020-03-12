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
    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return null;
        int length = grid.length;
        if (length == 1) {
            int gridVal = grid[0][0];
            boolean val = gridVal == 1 ? true : false;
            Node root = new Node(val, true, null, null, null, null);
            return root;
        } else {
            int halfLength = length / 2;
            int[][] topLeftGrid = new int[halfLength][halfLength];
            int[][] topRightGrid = new int[halfLength][halfLength];
            int[][] bottomLeftGrid = new int[halfLength][halfLength];
            int[][] bottomRightGrid = new int[halfLength][halfLength];
            for (int i = 0; i < halfLength; i++) {
                for (int j = 0; j < halfLength; j++) {
                    topLeftGrid[i][j] = grid[i][j];
                    topRightGrid[i][j] = grid[i][j + halfLength];
                    bottomLeftGrid[i][j] = grid[i + halfLength][j];
                    bottomRightGrid[i][j] = grid[i + halfLength][j + halfLength];
                }
            }
            Node topLeft = construct(topLeftGrid);
            Node topRight = construct(topRightGrid);
            Node bottomLeft = construct(bottomLeftGrid);
            Node bottomRight = construct(bottomRightGrid);
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
                Node root = new Node(topLeft.val, true, null, null, null, null);
                return root;
            } else {
                boolean val = topLeft.val || topRight.val || bottomLeft.val || bottomRight.val;
                Node root = new Node(val, false, topLeft, topRight, bottomLeft, bottomRight);
                return root;
            }
        }
    }
}