/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        depthFirstSearch(root1, counts1);
        depthFirstSearch(root2, counts2);
        return Arrays.equals(counts1, counts2);
    }

    public void depthFirstSearch(Node root, int[] counts) {
        if (root.left == null && root.right == null)
            counts[root.val - 'a']++;
        else {
            depthFirstSearch(root.left, counts);
            depthFirstSearch(root.right, counts);
        }
    }
}